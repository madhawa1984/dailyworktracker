package com.oriansolution.dwt.service.impl;

import com.oriansolution.dwt.dao.BranchDao;
import com.oriansolution.dwt.dao.DailyWorkRequestDao;
import com.oriansolution.dwt.dto.*;
import com.oriansolution.dwt.exception.JobRequestNotFound;
import com.oriansolution.dwt.exception.UserAndRoleNotFound;
import com.oriansolution.dwt.model.*;
import com.oriansolution.dwt.service.DailyWorkService;
import com.oriansolution.dwt.utility.DateUtil;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 11/26/16.
 */
@Service("DailyworkServiceBean")
public class DailyWorkServiceImpl implements DailyWorkService {
    @Autowired
    private DailyWorkRequestDao requestDao;
    @Autowired
    private BranchDao branchDao;

    private WorkRequest generateJobRequestfromReqDto(DailyWorkRequestDto request) {

        WorkRequest newWorkRequest = new WorkRequest();
        newWorkRequest.setDelieveryFormat(request.getDelieveryFormat());
        newWorkRequest.setFrequency(request.getFrequency());

        ArrayList<Comment> commentList = new ArrayList<Comment>();
        for(CommentsDto commentdto:request.getComments()) {
            Comment comment= new Comment();
            comment.setCommentedUsedId(commentdto.getCommentedUserUPMID());
            comment.setComment(commentdto.getComment());
            comment.setCreatedDate(new Date());
            comment.setWorkRequest(newWorkRequest);// to support bidirectional link
            commentList.add(comment);
            // TODO::  Save Commented RequestorDetail - this needs to have the current logged in user
        }

        newWorkRequest.setListOfComments(commentList);

        // save contact details
        ArrayList<ContactDetails> contactDetails = new ArrayList<ContactDetails>();
        for (ContactDetailsDto contactDto:request.getContactDetails()) {
            ContactDetails contacts = new ContactDetails();
            contacts.setContact(contactDto.getContact());
            contacts.setContactType(contactDto.getContactType());
            contacts.setWorkRequest(newWorkRequest); // to support bidirectional link
            contactDetails.add(contacts);
        }

        newWorkRequest.setListOfContacts(contactDetails);

        RequestorDetail requestorDetail = new RequestorDetail();
        requestorDetail.setFirstName(request.getName());
        requestorDetail.setRequestorUpmServiceId(request.getEmployeeId()); // Employeed id
        //requestorDetail.setLastName(request.);
        // requestorId
        requestorDetail.setDesignation(request.getDesignation());
        newWorkRequest.setRequestor(requestorDetail); // for each requestor requestwise should insert a record, // but employee if exists no need to put to employee insert

        Branch branch = null;
        BranchDto branchDto = request.getBranch();
        branch = branchDao.getBranchByUpfId(branchDto.getBranchCode());
        // search for the branch if exists save with the loaded id or try not to save.if not going to save check what will
        // happpen to the relationship
        // Save Branch
        if(branch == null) {
            branch = new Branch();
        }
        // branch.setId(1002);
        branch.setBranchName(branchDto.getBranchName());
        branch.setBranchLocation(branchDto.getBranchLocation());
        branch.setUpfServiceBranchId(branchDto.getBranchCode());
        branch.setCreatedTime(DateUtil.getDateInGivenFormat(new Date().toString(),"dd/MM/yyyy")); // check this date
        newWorkRequest.setCreatedDate(DateUtil.getDateInGivenFormat(new Date(), "dd/MM/yyyy"));
        newWorkRequest.setDueDate(DateUtil.getDateInGivenFormat(request.getDueDate(), "dd/MM/yyyy"));
        newWorkRequest.setBranch(branch);

        newWorkRequest.setAssignedUserUPMID(request.getAddignedUserUPMID()); // UPF service Id
        newWorkRequest.setInitiatedDepartment(request.getInitiatedDepartment());
        newWorkRequest.setDelieveryFormat(request.getDelieveryFormat());
        newWorkRequest.setDelieveryMode(request.getDelieveryMode());
        newWorkRequest.setFrequency(request.getFrequency());
        newWorkRequest.setBusinessPurpose(request.getBusinessPurpose());
        newWorkRequest.setReportTitle(request.getReportTitle());
        newWorkRequest.setRequiredColumns(request.getRequiredColumns());
        newWorkRequest.setFilterCritetia(request.getFilteringCriteria());
        newWorkRequest.setStatus(request.getStatus());
        newWorkRequest.setDelieveryMode(request.getDelieveryMode());
        newWorkRequest.setPriority(request.getPriority());

        return newWorkRequest;
    }

    @Override
    public DailyWorkRequestDto publishRequest(DailyWorkRequestDto request) throws Exception {

        WorkRequest workRequest = generateJobRequestfromReqDto(request);
        requestDao.createRequest(workRequest);
        // saved request loaded again entrirely from the DB and modified the DTO Object and sent to
        // the CLient. check the performance.
        /*request.setId(workRequest.getId());
        return request;*/
        request = getRequest(workRequest.getId()); // check the performance since the dailyWork/{id}
        // saved object will be fetched again by the generated identiy ID
        return request;
    }



    private ArrayList<CommentsDto> updateCommentsDto(WorkRequest  wrkRequest) {
        ArrayList<CommentsDto> commentsDto = new ArrayList<CommentsDto>();
        for(Comment cm:wrkRequest.getListOfComments()) {
            CommentsDto cmtDto = new CommentsDto();
            cmtDto.setId(cm.getCommentId());
            cmtDto.setComment(cm.getComment());
            cmtDto.setCommentedUserUPMID(cm.getCommentedUsedId());
            if (cm.getCreatedDate() != null) {
                cmtDto.setCreatedDate(cm.getCreatedDate().toString()); // check this conversion is oks
            }

            if (cm.getModifieddDate() != null) {
                cmtDto.setModifieddDate(cm.getModifieddDate().toString());
            }
            cmtDto.setWorkRequestId(Long.toString(wrkRequest.getId()));
            commentsDto.add(cmtDto);
        }
        return commentsDto;
    }

    private ArrayList<ContactDetailsDto> updateContactDetailsDto(WorkRequest  wrkRequest) {
        ArrayList<ContactDetailsDto> contactDetailsDtos = new ArrayList<ContactDetailsDto>();
        for(ContactDetails contactDetail:wrkRequest.getListOfContacts()) {
            ContactDetailsDto contactDetailsDto = new ContactDetailsDto();
            contactDetailsDto.setId(contactDetail.getId());
            contactDetailsDto.setContact(contactDetail.getContact());
            contactDetailsDto.setContactType(contactDetail.getContactType());
            contactDetailsDtos.add(contactDetailsDto);
        }
        return contactDetailsDtos;

    }


    public DailyWorkRequestDto generateJobRequestDto(WorkRequest  wrkRequest) {
        DailyWorkRequestDto wrkRequestDto = null;
        if (wrkRequest!=null) {
            wrkRequestDto = new DailyWorkRequestDto();
            Branch branch = wrkRequest.getBranch();
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branch.getId());
            branchDto.setBranchCode(branch.getUpfServiceBranchId());
            branchDto.setBranchLocation(branch.getBranchLocation());
            branchDto.setBranchName(branch.getBranchName());
            wrkRequestDto.setBranch(branchDto);

            wrkRequestDto.setComments(updateCommentsDto(wrkRequest));
            // ASSIGNED USER
            wrkRequestDto.setAddignedUserUPMID(wrkRequest.getAssignedUserUPMID());
            // ASSIGNED STATUS
            wrkRequestDto.setStatus(wrkRequest.getStatus());
            wrkRequestDto.setId(wrkRequest.getId());

            if (wrkRequest.getCreatedDate() != null) {
                wrkRequestDto.setRequestedDate(wrkRequest.getCreatedDate().toString());//NULL How to handle ENTITY level set default date
            }
            if (wrkRequest.getDueDate() != null) {
                wrkRequestDto.setDueDate(wrkRequest.getDueDate().toString());
            }
            if (wrkRequest.getModifiedDate() != null) {
                wrkRequestDto.setModifiedDate(wrkRequest.getModifiedDate().toString());
            }
            if (wrkRequest.getClosedDate() != null) {
                wrkRequestDto.setClosedDate(wrkRequest.getClosedDate().toString());
            }
            wrkRequestDto.setDelieveryFormat(wrkRequest.getDelieveryFormat());
            wrkRequestDto.setFrequency(wrkRequest.getFrequency());
            wrkRequestDto.setInitiatedDepartment(wrkRequest.getInitiatedDepartment());
            wrkRequestDto.setDelieveryMode(wrkRequest.getDelieveryMode());
            wrkRequestDto.setBusinessPurpose(wrkRequest.getBusinessPurpose());
            wrkRequestDto.setReportTitle(wrkRequest.getReportTitle());
            wrkRequestDto.setName(wrkRequest.getRequestor().getFirstName());
            wrkRequestDto.setLastName(wrkRequest.getRequestor().getLastName());
            wrkRequestDto.setDesignation(wrkRequest.getRequestor().getDesignation());
            wrkRequestDto.setEmployeeId(wrkRequest.getRequestor().getRequestorUpmServiceId());
            wrkRequestDto.setFilteringCriteria(wrkRequest.getFilterCritetia());
            wrkRequestDto.setRequiredColumns(wrkRequest.getRequiredColumns());
            wrkRequestDto.setContactDetails(updateContactDetailsDto(wrkRequest));
            wrkRequestDto.setStatus(wrkRequest.getStatus());
            wrkRequestDto.setPriority(wrkRequest.getPriority());
        }

        return wrkRequestDto;
    }

    @Override
    public DailyWorkRequestDto getRequest(long requestId) throws Exception {
        DailyWorkRequestDto wrkRequestDto = null;
        WorkRequest  wrkRequest = requestDao.getRequestById(requestId);
        if (wrkRequest !=null) {
            wrkRequestDto = generateJobRequestDto(wrkRequest);
        } else {
            throw new JobRequestNotFound("Given JOB ID IS NOT AVAILABLE");
        }

        return wrkRequestDto;
    }

    public ArrayList<RequestSummaryDto> generateSummaryDto(List<WorkRequest> summary) throws Exception {
        ArrayList<RequestSummaryDto> summaryDtoList = new ArrayList<RequestSummaryDto>();
        RequestSummaryDto summaryDto = new RequestSummaryDto();
        for(WorkRequest jobReq:summary) {
            summaryDto.setBusinessPurpose(jobReq.getBusinessPurpose());
            summaryDto.setDueDate(DateUtil.getDateInGivenFormat(jobReq.getDueDate(),"dd/MM/yyyy").toString());
            summaryDto.setPriority(jobReq.getPriority());
            summaryDto.setRequestedBy(jobReq.getRequestor().getFirstName());
            summaryDto.setRequestedDate(DateUtil.getDateInGivenFormat(jobReq.getCreatedDate(),
                    "dd/MM/yyyy").toString());
            summaryDto.setRequestId(Long.toString(jobReq.getId()));
            summaryDto.setStatus(jobReq.getStatus());
            summaryDto.setTittle(jobReq.getReportTitle());
            summaryDtoList.add(summaryDto);
        }
        return summaryDtoList;
    }

    @Override
    public ArrayList<RequestSummaryDto> getRequestSummary(String userId) throws Exception {
        List<WorkRequest> summary = requestDao.getRequestSummary(userId);
        return generateSummaryDto(summary);

    }

    @Override
    public ArrayList<RequestSummaryDto> getRequestSummaryByBranch(String upmBranchId) throws Exception {
        List<WorkRequest> summary = requestDao.getRequestSummaryByBranch(upmBranchId);
        return generateSummaryDto(summary);
    }



    // --------------------older implementation ---------------------------------------------------------
    private List<Comment> updateCommentsModel(List<CommentsDto> commentsDto,WorkRequest jobRequesModelObj) {
        List<Comment> commentList = new ArrayList<Comment>();
        for(CommentsDto commentdto: commentsDto) {
            Comment comment= new Comment();
            comment.setCommentId(commentdto.getId());
            comment.setCommentedUsedId(commentdto.getCommentedUserUPMID());
            comment.setComment(commentdto.getComment());
            comment.setCreatedDate(new Date());
            comment.setWorkRequest(jobRequesModelObj);// to support bidirectional link
            commentList.add(comment);
            // TODO::  Save Commented RequestorDetail - this needs to have the current logged in user
        }
        return commentList;
    }

    public WorkRequest generateModifiedWorkRequest(WorkRequest jobRequesModelObj,DailyWorkRequestDto jobRequestDto) throws Exception {

        // modify the WorkRequest with data from DTO.Before do the update need to verify which fileds are going to modify
        // how to edit the comments and how to dletet the comments.
        // a) if the current logged user is equal to the requestor he can edit followings
        //      1) description 2) close date 3) due date 4) title 5) his comments only
        // b) if the logged in user is an assigned user
        //        1) can edit his comments only
        //        2) status
        // c) any other he can add work notes and edit his comments
                // 1) edit previous comment
                // 2) add new comment
        //
        String currentUser = jobRequestDto.getCurrentUserId();
        String currentUserRole = jobRequestDto.getCurrentUserRole();

        if( currentUser !=null && currentUserRole!=null) {

            if (currentUser.equals(jobRequesModelObj.getRequestor().getRequestorUpmServiceId())) {
                // requestor is going to modify the request
                jobRequesModelObj.setDelieveryMode(jobRequestDto.getDelieveryMode());
                jobRequesModelObj.setDelieveryFormat(jobRequestDto.getDelieveryFormat());
                jobRequesModelObj.setBusinessPurpose(jobRequestDto.getBusinessPurpose());
                jobRequesModelObj.setDueDate(DateUtil.getDateInGivenFormat(jobRequestDto.getDueDate(), "dd/MM/yyyy"));
                jobRequesModelObj.setAssignedUserUPMID(jobRequestDto.getAddignedUserUPMID()); // this should pick the current user's manager by the back end it self.
                //user assignment should happen at backend for current users manager.
                // status modification
                jobRequesModelObj.setStatus(jobRequestDto.getStatus());
                // EDIT Comments
                jobRequesModelObj.setListOfComments(updateCommentsModel(jobRequestDto.getComments(), jobRequesModelObj));
                // EDIT Contacts
            /*
            String businessPurpose = jobRequestDto.getBusinessPurpose();
            if(!jobRequesModelObj.getBusinessPurpose().equals(businessPurpose)) {
                jobRequesModelObj.setBusinessPurpose(businessPurpose);
            }*/

                System.out.println("requestor is going to modify the request");
            } else if (currentUser.equals(jobRequesModelObj.getAssignedUserUPMID())) {
                // assigned user is going to modiify the request
                jobRequesModelObj.setAssignedUserUPMID(jobRequestDto.getAddignedUserUPMID());
                jobRequesModelObj.setStatus(jobRequestDto.getStatus());
                jobRequesModelObj.setListOfComments(updateCommentsModel(jobRequestDto.getComments(), jobRequesModelObj));
                System.out.println("assigned user is going to modify the request");
            } else if (currentUserRole.equals("MANAGER")) {

                // he directly not involved with request but if he is a manager of
                // 1) requestor 2) initiated department 3) some other department head he can change the assign status
                // modify the comments
                jobRequesModelObj.setAssignedUserUPMID(jobRequestDto.getAddignedUserUPMID());
                jobRequesModelObj.setStatus(jobRequestDto.getStatus());
                jobRequesModelObj.setListOfComments(updateCommentsModel(jobRequestDto.getComments(), jobRequesModelObj));

                System.out.println("Manager user is going to modify the request");
            } else {
                jobRequesModelObj.setStatus(jobRequestDto.getStatus());
                jobRequesModelObj.setListOfComments(updateCommentsModel(jobRequestDto.getComments(), jobRequesModelObj));
                // he can only modif the comments of his and add new comments
                System.out.println("Commentor user is going to modify the request");
            }
        } else {
            throw new UserAndRoleNotFound("Current Logged in user's UserId/Role Not found");
        }
        return jobRequesModelObj;
    }


    @Override
    public DailyWorkRequestDto modifyRequest(DailyWorkRequestDto jobRequestDto) throws Exception {
        WorkRequest jobRequesModelObj = requestDao.getRequestById(jobRequestDto.getId());

        if (jobRequesModelObj!=null) {
            generateModifiedWorkRequest(jobRequesModelObj,jobRequestDto);
            requestDao.updateRequest(jobRequesModelObj);

            //jobRequestDto = getRequest(jobRequesModelObj.getId());
        }else {
            throw new JobRequestNotFound("Job request could not find under id :-"+jobRequestDto.getId());
        }

        return jobRequestDto;
    }


}
