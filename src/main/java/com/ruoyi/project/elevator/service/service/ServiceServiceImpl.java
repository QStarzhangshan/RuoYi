package com.ruoyi.project.elevator.service.service;

import com.ruoyi.project.elevator.service.domain.Service;
import com.ruoyi.project.elevator.service.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service("ServiceService")
public class ServiceServiceImpl implements ServiceService {

   @Autowired
   private ServiceMapper serviceMapper;

    @Override
    public int insertTask(Service service) {
        return serviceMapper.insertTask(service);
    }

    @Override
    public int saveTask(Service service) {

        int count = serviceMapper.insertTask(service);
        return count;
    }

    @Override
    public List<Service> selectServiceList(Service service) {
        return serviceMapper.selectServiceList(service);
    }

    @Override
    public Service selectServiceById(long id) {
        return serviceMapper.selectServiceById(id);
    }

    @Override
    public int selectTaskById(long service_id) {
        return serviceMapper.selectTaskById(service_id);
    }

	@Override
	public Service selectServiceByServiceId(Long id) {
		return serviceMapper.selectServiceBySerivceId(id);
	}
}
