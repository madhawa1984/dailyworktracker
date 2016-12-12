package com.oriansolution.dwt.service;

import com.oriansolution.dwt.dto.DailyWorkRequestDto;

import java.util.List;

/**
 * Created by madhawa on 11/26/16.
 */
public interface DailyWorkService {
    public DailyWorkRequestDto publishRequest(DailyWorkRequestDto request) throws Exception;
    public DailyWorkRequestDto getRequest(long requestId) throws Exception;
    public List<DailyWorkRequestDto> getRequestSummary(long userId);
}
