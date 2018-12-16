package com.ruoyi.project.elevator.status.service;

import com.ruoyi.project.elevator.status.domain.ElevatorStatus;

import java.util.List;

public interface ElevatorStatusService {

    List<ElevatorStatus> selectElevatorStatusList(ElevatorStatus elevatorStatus);

    ElevatorStatus selectElevatorStatusByUserName(long id);

    List<ElevatorStatus> selectElevatorStatusAll();

    int insertElevatorStatus(ElevatorStatus elevatorStatus);

    int saveElevatorStatus(ElevatorStatus elevatorStatus);

    int checkElevatorStatusUnique(String elevator_number);

	List<String> findAllregistrationCode();

	List<ElevatorStatus> selectIotDevice();

}
