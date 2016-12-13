package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.WorkRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhawa on 11/23/16.
 */
public interface DailyWorkRequestDao {
    public WorkRequest createRequest(WorkRequest request);
    public WorkRequest getRequestById(long requestId) throws Exception;
    public List<WorkRequest> getRequestSummary(String upmUserId) throws Exception;
    public List<WorkRequest> getRequestSummaryByBranch(String branchId) throws Exception;
}
