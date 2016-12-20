package com.oriansolution.dwt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oriansolution.dwt.model.Comment;
import com.oriansolution.dwt.model.ContactDetails;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by madhawa on 11/15/16.
 */
// this class should be the json body for the POST of DWT jobs creation
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWorkRequestDto {
    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getInitiatedDepartment() {
        return initiatedDepartment;
    }

    public void setInitiatedDepartment(String initiatedDepartment) {
        this.initiatedDepartment = initiatedDepartment;
    }

    public String getAddignedUserUPMID() {
        return addignedUserUPMID;
    }

    public void setAddignedUserUPMID(String addignedUserUPMID) {
        this.addignedUserUPMID = addignedUserUPMID;
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

    public ArrayList<ContactDetailsDto> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ArrayList<ContactDetailsDto> contactDetails) {
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

    public String getDelieveryMode() {
        return delieveryMode;
    }

    public void setDelieveryMode(String delieveryMode) {
        this.delieveryMode = delieveryMode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCurrentUserId() {
        return currentUserId;
    }
    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
    public String getCurrentUserRole() {
        return currentUserRole;
    }
    public void setCurrentUserRole(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    private long id;
    @JsonProperty("requested_date")
    private String requestedDate;
    @JsonProperty("previous_request")
    private String previousRequestId;
    @JsonProperty("delivery_format")
    private String delieveryFormat;
    @JsonProperty("frequency")
    private String frequency;
    @JsonProperty("request_type")
    private String requestType;
    @JsonProperty("delievery_mode")
    private String delieveryMode;
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
    @JsonProperty("initiated_department")
    private String initiatedDepartment;
    @JsonProperty("assigned_user_upmid")
    private String addignedUserUPMID;
    private String status;
    // employee spacific data .may be able to put into another dto with employee
    @JsonProperty("employee_id")
    private String employeeId; // this will put to the upfmservice id.// when doing a request this will be the requestor id and current loggged in user id,
    // but when you about to modify a request this will different from the curren user id since original request is from some one else.to track that followong attributes comes
    // below attribute is not going to be persistence on any where
    @JsonProperty("currentuser_id")
    private String currentUserId; // upmServices userId
    @JsonProperty("currentuser_role")
    private String currentUserRole;
    private String name;
    private String designation;
    //private String branch;
    private BranchDto branch;
    @JsonProperty("contact_details")
    private ArrayList<ContactDetailsDto> contactDetails;
    private String closedDate;
    private String modifiedDate;
    private String lastName;



    // employee data

 }
