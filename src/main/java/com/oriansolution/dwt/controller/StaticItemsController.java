package com.oriansolution.dwt.controller;

import com.oriansolution.dwt.dto.BranchDto;
import com.oriansolution.dwt.dto.StaticItemsDto;
import com.oriansolution.dwt.service.StaticItemService;
import com.oriansolution.dwt.utility.enums.EnumContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("StaticItemsServiceBean")
    @Autowired
    private StaticItemService staticItemService;

    @RequestMapping(value="/priority_list",method= RequestMethod.GET)
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
        }
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }

    @RequestMapping(value="/designations_list",method= RequestMethod.GET)
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
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/requestTypes_list",method= RequestMethod.GET)
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
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/delievery_format",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getDelieveryFormat() throws Exception {
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();

        //return Arrays.asList(EnumContainer.Priority.values());
        StaticItemsDto item = null;
        for (EnumContainer.DelieveryFormat type : EnumContainer.DelieveryFormat.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/frequency_list",method= RequestMethod.GET)
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
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }

    @RequestMapping(value="/delievery_mode",method= RequestMethod.GET)
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
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;

    }


    @RequestMapping(value="/branches_list",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getBranches() throws Exception {
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();

        StaticItemsDto item = null;
        for(BranchDto branchDto : staticItemService.getBranchList()){
            item = new StaticItemsDto();
            item.setName(branchDto.getBranchName());
            item.setText(branchDto.getBranchName());
            item.setValue((int) branchDto.getId());
            staticItems.add(item);
        }
        staticItemsMap.put("response", staticItems);
        return staticItemsMap;
    }

    @RequestMapping(value="/status_list",method= RequestMethod.GET)
    public HashMap<String,List<StaticItemsDto>> getStatuslist() throws Exception {
        HashMap<String,List<StaticItemsDto>> staticItemsMap = new HashMap<String,List<StaticItemsDto>>();
        ArrayList<StaticItemsDto>  staticItems= new ArrayList<StaticItemsDto>();

        StaticItemsDto item = null;
        for (EnumContainer.Status type : EnumContainer.Status.values()) {
            item = new StaticItemsDto();
            item.setName(type.getName());
            item.setText(type.getText());
            item.setValue(type.getValue());
            staticItems.add(item);

        }
        staticItemsMap.put("response", staticItems);

        return staticItemsMap;
    }

}




