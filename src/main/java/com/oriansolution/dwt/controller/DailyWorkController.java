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

    @Autowired
    @Qualifier("DailyworkServiceBean")
    private DailyWorkService dailworkServiceObj;

    @RequestMapping(value="/dailyWork/{requestId}",method=RequestMethod.GET)
    public @ResponseBody
    DailyWorkRequestDto read(@PathVariable long requestId) throws Exception{

        DailyWorkRequestDto workRequestDto = dailworkServiceObj.getRequest(requestId);
        return workRequestDto;

    }

    @RequestMapping(value="/request",method=RequestMethod.POST)
    public @ResponseBody DailyWorkRequestDto create(@RequestBody DailyWorkRequestDto request) throws Exception {

        DailyWorkRequestDto savedResult = dailworkServiceObj.publishRequest(request);
        return savedResult;

    }



}
