package com.ruoyi.project.elevator.service.mapper;

import com.ruoyi.project.elevator.service.domain.Service;

import java.util.List;

public interface ServiceMapper {

    int insertTask(Service service);

    List<Service> selectServiceList(Service service);

    Service selectServiceById(long id);

    int selectTaskById(long service_id);

	Service selectServiceBySerivceId(Long id);

}
