package com.oriansolution.dwt.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 11/15/16.
 */
@Entity
@Table(name="WORKREQUEST")
public class WorkRequest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // need to considere about the custom id generation
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "REQUEST_ID")
    private String requestID;
    @Column(name = "DELIEVERY_FORMAT")
    private String delieveryFormat;
    @Column(name = "DELIEVERY_MODE")
    private String delieveryMode;
    @Column(name = "FREQUENCY")
    private String frequency;
    @Column(name="ASSIGNED_USER_UPMID")
    private String assignedUserUPMID;
    @Column(name="STATUS")
    private String status;
    @Column(name="CREATED_DATE")
    private Date createdDate;
    @Column(name="DUE_DATE")
    private Date dueDate;
    @Column(name="MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name="CLOSED_DATE")
    private Date closedDate;
    @Column(name="BUSINESS_PURPOSE")
    private String businessPurpose;
    @Column(name="REPORT_TITLE")
    private String reportTitle;
    @Column(name="INITIATED_DEPARTMENT")
    private String initiatedDepartment;
    @Column(name="REQUIRED_COLUMNS")
    private String requiredColumns;
    @Column(name="FILTER_CRITERIA")
    private String filterCritetia;
    @Column(name="PRIORITY")
    private String priority;



    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // comment relationship<onre request is having many comments .comment will have only one request id >
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "workRequest")
    //@JoinTable(name="WORK_REQUEST_COMMENTS",@JoinColumns=@JoinColumn("ID"))
    private List<Comment> listOfComments;

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "workRequest")
    private List<ContactDetails> listOfContacts;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="BRANCH_ID_OF_REQUEST")

    private Branch branch;
    @Embedded
    private RequestorDetail requestor;

    public String getRequiredColumns() {
        return requiredColumns;
    }

    public void setRequiredColumns(String requiredColumns) {
        this.requiredColumns = requiredColumns;
    }

    public String getFilterCritetia() {
        return filterCritetia;
    }

    public void setFilterCritetia(String filterCritetia) {
        this.filterCritetia = filterCritetia;
    }


    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getDelieveryMode() {
        return delieveryMode;
    }

    public void setDelieveryMode(String delieveryMode) {
        this.delieveryMode = delieveryMode;
    }

    public String getInitiatedDepartment() {
        return initiatedDepartment;
    }

    public void setInitiatedDepartment(String initiatedDepartment) {
        this.initiatedDepartment = initiatedDepartment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedUserUPMID() {
        return assignedUserUPMID;
    }

    public void setAssignedUserUPMID(String assignedUserUPMID) {
        this.assignedUserUPMID = assignedUserUPMID;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public RequestorDetail getRequestor() {
        return requestor;
    }

    public void setRequestor(RequestorDetail requestor) {
        this.requestor = requestor;
    }

    public List<Comment> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<Comment> listOfComments) {
        this.listOfComments = listOfComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
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


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public List<ContactDetails> getListOfContacts() {
        return listOfContacts;
    }

    public void setListOfContacts(List<ContactDetails> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }

}
