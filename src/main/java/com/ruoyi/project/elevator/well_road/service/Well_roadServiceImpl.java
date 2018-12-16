package com.ruoyi.project.elevator.well_road.service;

import com.ruoyi.project.elevator.well_road.domain.Well_road;
import com.ruoyi.project.elevator.well_road.mapper.Well_roadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Well_roadServiceImpl implements Well_roadService{
	
	
	@Autowired
	private Well_roadMapper well_roadMapper;

	@Override
	public int insertWell_road(Well_road well_road) {
		return well_roadMapper.insertWell_road(well_road);
	}
}
