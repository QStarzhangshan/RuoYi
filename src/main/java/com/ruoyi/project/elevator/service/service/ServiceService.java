package com.ruoyi.project.elevator.service.service;

import com.ruoyi.project.elevator.service.domain.Service;

import java.util.List;

public interface ServiceService {

    int insertTask(Service service);

    int saveTask(Service service);

    List<Service> selectServiceList(Service service);

    Service selectServiceById(long id);

    int selectTaskById(long service_id);

	Service selectServiceByServiceId(Long id);

}
