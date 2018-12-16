package com.ruoyi.project.elevator.mqtt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.elevator.mqtt.domain.IotDevice;
import com.ruoyi.project.elevator.mqtt.domain.RealTimeData;
import com.ruoyi.project.elevator.mqtt.mapper.RealTimeDataMapper;
import com.ruoyi.project.elevator.mqtt.service.RealTimeDataService;

@Service
public class RealTimeDataServiceImpl implements RealTimeDataService{

	@Autowired
	private RealTimeDataMapper realTimeDataMapper;
	
	@Override
	public void insertData(String topic,String current_status, String play_way, String door_status, String current_rank,
			String play_direction, String play_speed) {
		realTimeDataMapper.insertData(topic,current_status,play_way,door_status,current_rank,play_direction,play_speed);
		
	}

	@Override
	public RealTimeData seestatus(long id) {
		return realTimeDataMapper.seestatus(id);
	}

	@Override
	public List<RealTimeData> seehistory(Long id) {
		return realTimeDataMapper.seehistory(id);
	}

	@Override
	public int saveIotDevice(IotDevice iotDevice) {
		return realTimeDataMapper.saveIotDevice(iotDevice);
	}

}
