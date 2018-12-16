package com.ruoyi.project.user.sale.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.domain.UserPost;
import com.ruoyi.project.user.client.domain.Client;
import com.ruoyi.project.user.client.mapper.ClientMapper;
import com.ruoyi.project.user.sale.domain.Sale;
import com.ruoyi.project.user.sale.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SaleService")
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private ClientMapper clientMapper;


    @Override
    public List<Sale> selectSaleList(Sale sale) {
        return saleMapper.selectSaleList(sale);
    }

    @Override
    public List<Sale> selectSalesByUserId(Long saleId) {
        return null;
    }

    @Override
    public List<Sale> selectSalesAll() {
        return saleMapper.selectSalesAll();
    }

    @Override
    public Sale selectSaleById(Long saleId) {
        return saleMapper.selectSaleById(saleId);
    }

    @Override
    public int deleteSaleById(Long saleId) {
        return saleMapper.deleteSaleById(saleId);
    }

    @Override
    public int updateSale(Sale sale) {
        return saleMapper.updateSale(sale);
    }

    @Override
    public int saveSale(Sale sale){

        Long saleId = sale.getSaleId();
        int count = 0;
        if (StringUtils.isNotNull(saleId))
        {
            saleMapper.updateSale(sale);
            Client client = new Client();
            client.setClientName(sale.getClientName());
            client.setClientOwnerLoginName(sale.getUserLoginName());
            client.setSaleId(sale.getSaleId());
            clientMapper.updateClient(client);
            return 1;
        }
        else {
            saleMapper.insertSale(sale);
            //新增销售和客户之间的关系
            Client client = new Client();
            client.setClientName(sale.getClientName());
            client.setClientOwnerLoginName(sale.getUserLoginName());
            client.setSaleId(sale.getSaleId());
            count = clientMapper.insertClient(client);
            ShiroUtils.clearCachedAuthorizationInfo();
            return count;
        }

    }
    /**
     * 新增用户岗位信息
     *
     * @param sale 用户对象
     */
    public void insertSaleClient(Sale sale)
    {
        // 新增用户与岗位管理
        List<Client> list = new ArrayList<Client>();

    }


    public int checkSaleNameUnique(String saleName){
        int count = saleMapper.checkSaleNameUnique(saleName);
        if (count > 0)
        {
            return 1;
        }
        return 0;
    }
}
