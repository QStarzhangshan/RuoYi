package com.ruoyi.project.elevator.property.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.elevator.property.domain.Area;
import com.ruoyi.project.elevator.property.mapper.AreaMapper;
import com.ruoyi.project.elevator.property.service.AreaService;


@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaMapper areaMapper;

	@Override
	public int saveArea(Area area) {
		area.setDept_id(ShiroUtils.getDeptId());
		String dept_name = findByDeptId(ShiroUtils.getDeptId());
		area.setDept_name(dept_name);
		return areaMapper.saveArea(area);
	}

	private String findByDeptId(Long deptId) {
		return areaMapper.findByDeptId(deptId);
	}

	@Override
	public List<Area> selectAreaList() {
		return areaMapper.selectAreaList();
	}
}
