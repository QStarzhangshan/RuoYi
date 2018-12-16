package com.ruoyi.project.elevator.status.mapper;

import com.ruoyi.project.elevator.status.domain.ElevatorStatus;

import java.util.List;

public interface ElevatorStatusMapper {

    List<ElevatorStatus> selectElevatorStatusList(ElevatorStatus elevatorStatus);

    ElevatorStatus selectElevatorStatusByUserName(long id);

    List<ElevatorStatus> selectElevatorStatusAll();

    int insertElevatorStatus(ElevatorStatus elevatorStatus);

    int checkElevatorStatusUnique(String elevator_number);

	List<String> findAllregistrationCode();

	List<ElevatorStatus> selectIotDevice();
}
