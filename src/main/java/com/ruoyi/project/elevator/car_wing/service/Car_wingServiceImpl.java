package com.ruoyi.project.elevator.car_wing.service;


import com.ruoyi.project.elevator.car_wing.domain.Car_wing;
import com.ruoyi.project.elevator.car_wing.mapper.Car_wingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Car_wingService")
public class Car_wingServiceImpl implements Car_wingService{

	@Autowired
	private Car_wingMapper car_wingMapper;


	@Override
	public int insertCarWing(Car_wing car_wing) {
		return car_wingMapper.insertCarWing(car_wing);
	}
}
