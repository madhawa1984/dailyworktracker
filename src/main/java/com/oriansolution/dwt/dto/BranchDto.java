package com.oriansolution.dwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by madhawa on 12/7/16.
 */
public class BranchDto {
    private long id;
    @JsonProperty("value")
    private String branchCode;
    @JsonProperty("name")
    private String branchName;
    @JsonProperty("text")
    private String branchLocation;

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


