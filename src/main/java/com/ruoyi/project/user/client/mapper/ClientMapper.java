package com.ruoyi.project.user.client.mapper;

import com.ruoyi.project.user.client.domain.Client;
import java.util.List;

public interface ClientMapper {

    /**
     * 根据条件分页查询角色数据
     *
     * @param client 角色信息
     * @return 角色数据集合信息
     */
    public List<Client> selectClientList(Client client);

    /**
     * 根据客户ID查询角色
     *
     * @param clientId 用户ID
     * @return 角色列表
     */
    public List<Client> selectClientsByUserId(Long clientId);

    /**
     * 查询角色列表
     *
     * @return 角色列表
     */
    public List<Client> selectClientsAll();

    /**
     * 通过角色ID查询角色
     *
     * @param clientId 角色ID
     * @return 角色对象信息
     */
    public Client selectClientById(Long clientId);

    /**
     * 通过角色ID删除角色
     *
     * @param clientId 角色ID
     * @return 结果
     */
    public int deleteClientById(Long clientId);


    /**
     * 修改角色信息
     *
     * @paramsole 角色信息
     * @return 结果
     */
    public int updateClient(Client client);

    /**
     * 新增角色信息
     *
     * @param client 角色信息
     * @return 结果
     */
    public int insertClient(Client client);

    int checkClientNameUnique(String clientName);


}
