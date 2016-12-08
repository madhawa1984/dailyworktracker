package com.oriansolution.dwt.service.impl;

import com.oriansolution.dwt.dao.BranchDao;
import com.oriansolution.dwt.dao.DailyWorkRequestDao;
import com.oriansolution.dwt.dto.BranchDto;
import com.oriansolution.dwt.dto.CommentsDto;
import com.oriansolution.dwt.dto.DailyWorkRequestDto;
import com.oriansolution.dwt.model.Branch;
import com.oriansolution.dwt.model.Comment;
import com.oriansolution.dwt.model.RequestorDetail;
import com.oriansolution.dwt.model.WorkRequest;
import com.oriansolution.dwt.service.DailyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private WorkRequest getWorkRequestfromDto(DailyWorkRequestDto request) {
        // when these method executes check the reference types object id are same model and the dto
        // check the reference types will be same by setting null on the DTO class
        // whether work request values also get null
        // this object needs to be modified to add the relat'ion ships
        // so the entire tre strucutre will be saved.

        WorkRequest newWorkReequest = new WorkRequest();
        newWorkReequest.setDelieveryFormat(request.getDelieveryFormat());
        newWorkReequest.setFrequency(request.getFrequency());

        ArrayList<Comment> commentList = new ArrayList<Comment>();
        for(CommentsDto commentdto:request.getComments()) {
            Comment comment= new Comment();
            comment.setComment(commentdto.getComment());
            comment.setCreatedDate(new Date());
            comment.setWorkRequest(newWorkReequest);// to support bidirectional link
            commentList.add(comment);
            // TODO::  Save Commented RequestorDetail - this needs to have the current logged in user
        }

        newWorkReequest.setListOfComments(commentList);

        // Save Created RequestorDetail
        RequestorDetail requestorDetail = new RequestorDetail();
        requestorDetail.setFirstName(request.getName());
        //requestorDetail.setLastName(request.);
        requestorDetail.setDesignation(request.getDesignation());
        newWorkReequest.setRequestor(requestorDetail); // for each requestor requestwise should insert a record, // but employee if exists no need to put to employee insert

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
        branch.setCreatedTime(new Date());

        newWorkReequest.setBranch(branch);

        return newWorkReequest;
    }

    @Override
    // @Transactional
    public DailyWorkRequestDto publishRequest(DailyWorkRequestDto request) {
        // hard coded request will be published to the database; for initial test
        // then relation ship will be added
        WorkRequest workRequest=getWorkRequestfromDto(request);
        requestDao.createRequest(workRequest);
        request.setId(workRequest.getId());// pick the sequence id generated from the mysql
        return request;

    }

    // also modify the request should be possible

    @Override
    public DailyWorkRequestDto getRequest(long requestId) {
        return null;
    }

    @Override
    public List<DailyWorkRequestDto> getRequestSummary(long userId) {
        return null;
    }
}
