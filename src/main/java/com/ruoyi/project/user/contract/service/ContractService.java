package com.ruoyi.project.user.contract.service;

import com.ruoyi.project.user.contract.domain.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> selectContractList(Contract contract);

    int insertContract(Contract contract);

    int updateContract(Contract contract);

    int saveContract(Contract contract);

    int checkContractNameUnique(String contractTopic);

    Contract selectContractById(Long contractId);

}
