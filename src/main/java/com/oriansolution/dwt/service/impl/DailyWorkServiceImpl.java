package com.oriansolution.dwt.service.impl;

import com.oriansolution.dwt.dao.BranchDao;
import com.oriansolution.dwt.dao.DailyWorkRequestDao;
import com.oriansolution.dwt.dto.BranchDto;
import com.oriansolution.dwt.dto.CommentsDto;
import com.oriansolution.dwt.dto.ContactDetailsDto;
import com.oriansolution.dwt.dto.DailyWorkRequestDto;
import com.oriansolution.dwt.exception.JobRequestNotFound;
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

    @Override
    public List<DailyWorkRequestDto> getRequestSummary(long userId) {
        return null;
    }
}
