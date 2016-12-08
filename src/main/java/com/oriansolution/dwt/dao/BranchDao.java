package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.Branch;

/**
 * Created by madhawa on 12/7/16.
 */
public interface BranchDao {
    public Branch getBranchByUpfId(String upfServiceBranchId);
}
