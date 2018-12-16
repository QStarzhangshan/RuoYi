package com.ruoyi.project.user.contract.mapper;


import com.ruoyi.project.user.contract.domain.Contract;

import java.util.List;

public interface ContractMapper {


    List<Contract> selectContractList(Contract contract);

    int insertContract(Contract contract);

    Contract selectContractById(Long contractId);

    int updateContract(Contract contract);

    int checkContractNameUnique(String contractTopic);


}
