package com.oriansolution.dwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by madhawa on 12/12/16.t
 */
public class RequestSummaryDto {

    public String getRequestId() {
        return requestId;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("title")
    private String tittle;
    @JsonProperty("business_purpose")
    private String businessPurpose;
    @JsonProperty("requested_date")
    private String requestedDate; //"01/01/2016",
    @JsonProperty("requested_by")
    private String requestedBy;
    @JsonProperty("due_date")
    private String dueDate; //01/05/2016,
    private String status;
    private String priority;

}