package com.oriansolution.dwt.controller;

import com.oriansolution.dwt.dto.StaticItemsDto;
import com.oriansolution.dwt.utility.enums.EnumContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by madhawa on 12/20/16.
 */
@RestController
public class StaticItemsController {
    @RequestMapping(value="/getPriority",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getPriorityLevel() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.Priority priority : EnumContainer.Priority.values()) {
            item = new StaticItemsDto();
            item.setName(priority.getName());
            item.setText(priority.getText());
            item.setValue(priority.getValue());
            staticItems.add(item);
            System.out.println("________" + priority.getName() + "   " + priority.getText() + " .. " + priority.getValue());
        }
        staticItemsMap.put("priorityList", staticItems);
        return staticItemsMap;

    }

    @RequestMapping(value="/getDesignations",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getDesignations() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.Designations designation : EnumContainer.Designations.values()) {
            item = new StaticItemsDto();
            item.setName(designation.getName());
            item.setText(designation.getText());
            item.setValue(designation.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("designationList", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/getRequestTypes",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getRequestTypes() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.RequestTypes type : EnumContainer.RequestTypes.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("requestTypeList", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/getDelieveryFormat",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getDelieveryFormat() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.RequestTypes type : EnumContainer.RequestTypes.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("delieveryFormatList", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/getFrequency",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getFrequency() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.Frequency type : EnumContainer.Frequency.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("frequencyList", staticItems);
        return staticItemsMap;

    }





    @RequestMapping(value="/getDelieveryMode",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getDelieveryMode() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        StaticItemsDto item = null;
        for (EnumContainer.DelieveryMode type : EnumContainer.DelieveryMode.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("delieveryModeList", staticItems);
        return staticItemsMap;

    }

}




