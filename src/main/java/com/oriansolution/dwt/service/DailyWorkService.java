package com.oriansolution.dwt.service;

import com.oriansolution.dwt.dto.DailyWorkRequestDto;
import com.oriansolution.dwt.dto.RequestSummaryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhawa on 11/26/16.
 */
public interface DailyWorkService {
    public DailyWorkRequestDto publishRequest(DailyWorkRequestDto request) throws Exception;
    public DailyWorkRequestDto getRequest(long requestId) throws Exception;
    public ArrayList<RequestSummaryDto> getRequestSummary(String upmUserId) throws Exception;
    public ArrayList<RequestSummaryDto> getRequestSummaryByBranch(String upmBranchId) throws Exception;
    public DailyWorkRequestDto modifyRequest(DailyWorkRequestDto request) throws Exception;
}
