package com.ruoyi.project.elevator.mqtt.service;

import java.util.List;

import com.ruoyi.project.elevator.mqtt.domain.IotDevice;
import com.ruoyi.project.elevator.mqtt.domain.RealTimeData;

public interface RealTimeDataService {

	void insertData(String topic,String current_status, String play_way, String door_status, String current_rank,
			String play_direction, String play_speed);

	RealTimeData seestatus(long id);

	List<RealTimeData> seehistory(Long id);

	int saveIotDevice(IotDevice iotDevice);

}
