package com.oriansolution.dwt.service.impl;

import com.oriansolution.dwt.dao.BranchDao;
import com.oriansolution.dwt.dto.BranchDto;
import com.oriansolution.dwt.model.Branch;
import com.oriansolution.dwt.service.StaticItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhawa on 12/25/16.
 */
@Service("StaticItemsServiceBean")
public class StaticServiceImpl implements StaticItemService {
    @Autowired
    private BranchDao branchDao;
    @Override
    public List<BranchDto> getBranchList() throws Exception {
        List<BranchDto> branchListDto = new ArrayList<BranchDto>();
        for(Branch branch:branchDao.getBranchList()){
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branch.getId());
            branchDto.setBranchCode(branch.getUpfServiceBranchId());
            branchDto.setBranchName(branch.getBranchName());
            branchDto.setBranchLocation(branch.getBranchLocation());
            //branchDto.setId(branch.getId());
            branchListDto.add( branchDto);
        }
        return branchListDto;
    }
}
