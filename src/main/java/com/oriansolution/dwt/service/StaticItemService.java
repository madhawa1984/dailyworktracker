package com.oriansolution.dwt.service;

import com.oriansolution.dwt.dto.BranchDto;

import java.util.List;

/**
 * Created by madhawa on 12/25/16.
 */
public interface StaticItemService {
    public List<BranchDto> getBranchList() throws Exception;
}
