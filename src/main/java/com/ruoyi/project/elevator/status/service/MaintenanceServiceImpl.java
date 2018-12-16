package com.ruoyi.project.elevator.status.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.elevator.status.domain.Maintenance;
import com.ruoyi.project.elevator.status.mapper.MaintenanceMapper;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{

	@Autowired
	private MaintenanceMapper maintenanceMapper;

	@Override
	public Maintenance selectMaintenanceById(Long id) {
		return maintenanceMapper.selectMaintenanceById(id);
	}
	
	
}
