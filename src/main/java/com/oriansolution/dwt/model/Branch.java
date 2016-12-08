package com.oriansolution.dwt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 12/1/16.
 */
@Entity()
@Table(name="BRANCH")
public class Branch implements Serializable {

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SYSTEM_BRANCH_ID",unique = true,nullable = false)
    private long Id;
    // this needs to be unique
    @Column(name="UPFSERVICE_BRANCH_ID")
    private String upfServiceBranchId;
    @Column(name="BRANCHNAME")
    private String branchName;
    @Column(name="CREATEDTIME")
    private Date createdTime;
    @Column(name="BRANCH_LOCATION")
    private String branchLocation;

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "branch")
    private List<WorkRequest> workRequestList;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(List<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUpfServiceBranchId() {
        return upfServiceBranchId;
    }

    public void setUpfServiceBranchId(String upfServiceBranchId) {
        this.upfServiceBranchId = upfServiceBranchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }



}
