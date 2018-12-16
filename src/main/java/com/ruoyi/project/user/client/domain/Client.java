package com.ruoyi.project.user.client.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Client extends BaseEntity {

    private Long clientId;
    private Long saleId;
    private String clientName;
    private String clientOwnerLoginName;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientOwnerLoginName() {
        return clientOwnerLoginName;
    }

    public void setClientOwnerLoginName(String clientOwnerLoginName) {
        this.clientOwnerLoginName = clientOwnerLoginName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", saleId=" + saleId +
                ", clientName='" + clientName + '\'' +
                ", clientOwnerLoginName='" + clientOwnerLoginName + '\'' +
                '}';
    }
}
