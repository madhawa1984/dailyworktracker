package com.oriansolution.dwt.controller;

import com.oriansolution.dwt.exception.DwtBaseException;
import com.oriansolution.dwt.exception.JoBSummaryNotFound;
import com.oriansolution.dwt.exception.JobRequestNotFound;
import com.oriansolution.dwt.utility.DWTError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by madhawa on 12/11/16.
 */
@ControllerAdvice
@RestController
public class DwtExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public DWTError handleException(Exception e){
        e.printStackTrace();
        System.out.println("Error Occured");
        DWTError dwtError= new DWTError();
        dwtError.setErrorMessage(e.getMessage()); // try to use the builder patterns
        return dwtError;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({JobRequestNotFound.class,JoBSummaryNotFound.class})
    public DWTError handleJobNotFound(DwtBaseException e) {
        e.printStackTrace();
        DWTError dwtError= new DWTError();
        dwtError.setErrorMessage(e.getMessage()); // try to use the builder patterns
        return dwtError;
    }

}
