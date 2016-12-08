package com.oriansolution.dwt.controller;

import com.oriansolution.dwt.dto.AppStatus;
import com.oriansolution.dwt.dto.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

/**
 * Created by madlhawa on 11/14/16.
 */
@EnableConfigurationProperties(ApplicationProperties.class)
@RestController
public class StatusController {

    @Autowired
    private  AppStatus appStatus;

    @RequestMapping(value = "/dwtstatus",method = RequestMethod.GET)
    public @ResponseBody AppStatus status() {
        System.out.println ("________"+appStatus.getApplicationStatus()+"________");
        return appStatus;
    }

    @RequestMapping(value = "/dwtstatusString",method = RequestMethod.GET)
    public String strstatus() {
        return "ok";
    }

    @ExceptionHandler(Exception.class)
    public void errorloger(Exception ex) {
        ex.printStackTrace();
    }
}
