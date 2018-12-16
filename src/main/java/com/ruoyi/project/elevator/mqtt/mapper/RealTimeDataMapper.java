package com.ruoyi.project.elevator.mqtt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.project.elevator.mqtt.domain.IotDevice;
import com.ruoyi.project.elevator.mqtt.domain.RealTimeData;

public interface RealTimeDataMapper {

	void insertData(@Param("topic") String topic,@Param("current_status") String current_status,@Param("play_way") String play_way,@Param("door_status") String door_status,@Param("current_rank") String current_rank,
			@Param("play_direction") String play_direction,@Param("play_speed") String play_speed);

	RealTimeData seestatus(@Param("id") long id);

	List<RealTimeData> seehistory(@Param("id") Long id);

	int saveIotDevice(IotDevice iotDevice);

}
