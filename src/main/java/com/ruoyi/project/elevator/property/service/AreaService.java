package com.ruoyi.project.elevator.property.service;

import java.util.List;

import com.ruoyi.project.elevator.property.domain.Area;

public interface AreaService {

	int saveArea(Area area);

	List<Area> selectAreaList();

}
