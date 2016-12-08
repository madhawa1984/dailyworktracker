package com.oriansolution.dwt.controller;

import com.oriansolution.dwt.dto.AppStatus;
import com.oriansolution.dwt.dto.CommentsDto;
import com.oriansolution.dwt.dto.DailyWorkRequestDto;
import com.oriansolution.dwt.model.WorkRequest;
import com.oriansolution.dwt.service.DailyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by madhawa on 11/15/16.
 */
@RestController
public class DailyWorkController {

    /*@Autowired
    private DailyWorkRequestDao requestDao;*/
    @Autowired
    @Qualifier("DailyworkServiceBean")
    private DailyWorkService dailworkServiceObj;
    @Autowired
    private AppStatus appStatus;

    // this search needs to be done on the anyfiled.single text input filed(googles)
    @RequestMapping(value="/dailyWork/{requestId}",method=RequestMethod.GET)
    public @ResponseBody
    DailyWorkRequestDto read(@RequestBody DailyWorkRequestDto request) {

        // check here do we need to return the DTO object itself
        return null;// replace this value

    }

    @RequestMapping(value="/dailyWorkTest",method=RequestMethod.POST)
    public @ResponseBody DailyWorkRequestDto testPost() {
        // check here do we need to return the DTO object itself
        DailyWorkRequestDto testObj= new DailyWorkRequestDto();
        testObj.setFrequency("Weekly");
        testObj.setRequestedDate(new java.util.Date().toString());
        testObj.setDelieveryFormat("Excel");
        testObj.setEmployeeId("m0001");
        return dailworkServiceObj.publishRequest(testObj);



    }

    @RequestMapping(value="/request",method=RequestMethod.POST)
    public @ResponseBody DailyWorkRequestDto create(@RequestBody DailyWorkRequestDto request) {

        for(String contact:request.getContactDetails()) {
            System.out.println("contatcs"+contact);
        }
        // iterate over comments list
        for(CommentsDto comntObj:request.getComments()) {
            System.out.println("comments"+comntObj.getCreatedDate()+" "+comntObj.getComment());
        }

        DailyWorkRequestDto savedResult = dailworkServiceObj.publishRequest(request);

        return savedResult;

    }
}
