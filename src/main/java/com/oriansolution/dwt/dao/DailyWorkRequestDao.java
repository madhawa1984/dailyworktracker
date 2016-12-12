package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.WorkRequest;

/**
 * Created by madhawa on 11/23/16.
 */
public interface DailyWorkRequestDao {
    public WorkRequest createRequest(WorkRequest request);
    public WorkRequest getRequestById(long requestId) throws Exception;
}
