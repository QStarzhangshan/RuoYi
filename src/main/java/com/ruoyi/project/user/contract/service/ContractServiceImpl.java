package com.ruoyi.project.user.contract.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.user.client.domain.Client;
import com.ruoyi.project.user.contract.domain.Contract;
import com.ruoyi.project.user.contract.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContractService")
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> selectContractList(Contract contract) {
        return contractMapper.selectContractList(contract);
    }

    @Override
    public int insertContract(Contract contract) {
        return 0;

    }

    @Override
    public int updateContract(Contract contract) {
        return contractMapper.updateContract(contract);
    }

    @Override
    public int saveContract(Contract contract) {

        Long contractId = contract.getContractId();
        int count = 0;
        if (StringUtils.isNotNull(contractId))
        {
            contractMapper.updateContract(contract);
            return 1;
        }
        else {
           count = contractMapper.insertContract(contract);
            ShiroUtils.clearCachedAuthorizationInfo();
            return count;
        }
    }

    @Override
    public int checkContractNameUnique(String contractTopic) {
        int count = contractMapper.checkContractNameUnique(contractTopic);
        if (count > 0)
        {
            return 1;
        }
        return 0;

    }

    @Override
    public Contract selectContractById(Long contractId) {
        return contractMapper.selectContractById(contractId);
    }
}
