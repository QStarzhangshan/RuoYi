package com.ruoyi.project.elevator.status.mapper;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.project.elevator.status.domain.Maintenance;

public interface MaintenanceMapper {

	Maintenance selectMaintenanceById(@Param("id") Long id);

}
