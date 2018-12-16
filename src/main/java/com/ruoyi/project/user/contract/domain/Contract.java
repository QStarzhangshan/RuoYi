package com.ruoyi.project.user.contract.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Contract extends BaseEntity{

    private Long contractId;
    private String contractClient;
    private String contractTopic;
    private String contractOwner;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractClient() {
        return contractClient;
    }

    public void setContractClient(String contractClient) {
        this.contractClient = contractClient;
    }

    public String getContractTopic() {
        return contractTopic;
    }

    public void setContractTopic(String contractTopic) {
        this.contractTopic = contractTopic;
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner;
    }
}
