package com.ruoyi.project.user.client.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.user.client.domain.Client;
import com.ruoyi.project.user.client.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientService")
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> selectClientList(Client client) {
        return clientMapper.selectClientList(client);
    }

    @Override
    public List<Client> selectClientsByUserId(Long clientId) {
        return null;
    }

    @Override
    public List<Client> selectClientsAll() {
        return null;
    }

    @Override
    public Client selectClientById(Long clientId) {
        return clientMapper.selectClientById(clientId);
    }

    @Override
    public int deleteClientById(Long clientId) {
        return 0;
    }

    @Override
    public int updateClient(Client client) {
        return clientMapper.updateClient(client);
    }

    @Override
    public int insertClient(Client client) {
        return 0;
    }


    public int checkClientNameUnique(String clientName){
        int count = clientMapper.checkClientNameUnique(clientName);
        if (count > 0)
        {
            return 1;
        }
        return 0;
    }

    @Override
    public int saveClient(Client client){

        Long clientId = client.getClientId();
        int count = 0;
        if (StringUtils.isNotNull(clientId))
        {
            return 1;
        }
        else {
            count = clientMapper.insertClient(client);
            ShiroUtils.clearCachedAuthorizationInfo();
            return count;
        }

    }
}
