package com.oriansolution.dwt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oriansolution.dwt.model.Comment;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by madhawa on 11/15/16.
 */
// this class should be the json body for the POST of DWT jobs creation
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWorkRequestDto {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getPreviousRequestId() {
        return previousRequestId;
    }

    public void setPreviousRequestId(String previousRequestId) {
        this.previousRequestId = previousRequestId;
    }

    public String getDelieveryFormat() {
        return delieveryFormat;
    }

    public void setDelieveryFormat(String delieveryFormat) {
        this.delieveryFormat = delieveryFormat;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getRequiredColumns() {
        return requiredColumns;
    }

    public void setRequiredColumns(String requiredColumns) {
        this.requiredColumns = requiredColumns;
    }

    public String getFilteringCriteria() {
        return filteringCriteria;
    }

    public void setFilteringCriteria(String filteringCriteria) {
        this.filteringCriteria = filteringCriteria;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }

    public String getAddignedUser() {
        return addignedUser;
    }

    public void setAddignedUser(String addignedUser) {
        this.addignedUser = addignedUser;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ArrayList<String> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ArrayList<String> contactDetails) {
        this.contactDetails = contactDetails;
    }
    public ArrayList<CommentsDto> getComments() {
        return comments;
    }
    // need to maintain the order of the comment list check for the appropiate collection type

    public void setComments(ArrayList<CommentsDto> comments) {
        this.comments = comments;
    }
    public BranchDto getBranch() {
        return branch;
    }
    public void setBranch(BranchDto branch) {
        this.branch = branch;
    }

    private long id;
    @JsonProperty("requested_date")
    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private String requestedDate;
    @JsonProperty("previous_request")
    private String previousRequestId;
    @JsonProperty("delivery_format")
    private String delieveryFormat;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("request_type")
    private String requestType;
    @JsonProperty("delivery_mode")
    private String deliveryMode;
    @JsonProperty("required_columns")
    private String requiredColumns;// text asre how to handle ,larger text velus into string
    @JsonProperty("filtering_criteria")
    private String filteringCriteria;
    @JsonProperty("report_title")
    private String reportTitle;
    @JsonProperty("due_Date")
    private String dueDate;
    private String priority;
    @JsonProperty("business_purpose")
    private String businessPurpose;
    private ArrayList<CommentsDto> comments; // necessary
    @JsonProperty("Assigned_Department")
    private String assignedDepartment;
    @JsonProperty("Assigned_User")
    private String addignedUser;


    // employee spacific data .may be able to put into another dto with employee
    @JsonProperty("employee_id")
    private String employeeId;
    private String name;
    private String designation;
    //private String branch;
    private BranchDto branch;
    @JsonProperty("contact_details")
    private ArrayList<String> contactDetails;
    // employee data

 }
