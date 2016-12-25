package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.Branch;

import java.util.List;

/**
 * Created by madhawa on 12/7/16.
 */
public interface BranchDao {
    public List<Branch> getBranchList();
    public Branch getBranchByUpfId(String upfServiceBranchId);

}
