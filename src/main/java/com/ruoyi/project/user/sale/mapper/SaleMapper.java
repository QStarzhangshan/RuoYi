package com.ruoyi.project.user.sale.mapper;

import com.ruoyi.project.user.sale.domain.Sale;

import java.util.List;

public interface SaleMapper {

    /**
     * 根据条件分页查询角色数据
     *
     * @param sale 角色信息
     * @return 角色数据集合信息
     */
    public List<Sale> selectSaleList(Sale sale);

    /**
     * 根据用户ID查询角色
     *
     * @param saleId 用户ID
     * @return 角色列表
     */
    public List<Sale> selectSalesByUserId(Long saleId);

    /**
     * 查询角色列表
     *
     * @return 角色列表
     */
    public List<Sale> selectSalesAll();

    /**
     * 通过角色ID查询角色
     *
     * @param saleId 角色ID
     * @return 角色对象信息
     */
    public Sale selectSaleById(Long saleId);

    /**
     * 通过角色ID删除角色
     *
     * @param saleId 角色ID
     * @return 结果
     */
    public int deleteSaleById(Long saleId);


    /**
     * 修改角色信息
     *
     * @paramsole 角色信息
     * @return 结果
     */
    public int updateSale(Sale sale);

    /**
     * 新增销售
     *
     * @param sale 销售信息
     * @return 结果
     */
    public int insertSale(Sale sale);

    public int checkSaleNameUnique(String saleName);

}
