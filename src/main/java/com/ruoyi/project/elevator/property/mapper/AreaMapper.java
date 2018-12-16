package com.ruoyi.project.elevator.property.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.project.elevator.property.domain.Area;


public interface AreaMapper {

	String findByDeptId(@Param("deptId") Long deptId);

	int saveArea(Area area);

	List<Area> selectAreaList();

}
