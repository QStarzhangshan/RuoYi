package com.ruoyi.project.user.sale.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Sale extends BaseEntity {

    /** 销售ID */
    private Long saleId;
    /** 所属用户   */
    private String userLoginName;
    /** 客户名称*/
    private String clientName;
    /** 销售名 */
    private String saleName;

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", userLoginName='" + userLoginName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", saleName='" + saleName + '\'' +
                '}';
    }
}
