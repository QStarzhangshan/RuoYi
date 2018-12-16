package com.ruoyi.project.elevator.status.service;

import com.ruoyi.project.elevator.status.domain.ElevatorStatus;
import com.ruoyi.project.elevator.status.mapper.ElevatorStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ElevatorStatusService")
public class ElevatorStatusServiceImpl implements ElevatorStatusService {

    @Autowired
    private ElevatorStatusMapper elevatorStatusMapper;

    @Override
    public List<ElevatorStatus> selectElevatorStatusList(ElevatorStatus elevatorStatus) {
        return elevatorStatusMapper.selectElevatorStatusList(elevatorStatus);
    }

    @Override
    public ElevatorStatus selectElevatorStatusByUserName(long id) {
        return elevatorStatusMapper.selectElevatorStatusByUserName(id);
    }

    @Override
    public List<ElevatorStatus> selectElevatorStatusAll() {
        return elevatorStatusMapper.selectElevatorStatusAll();
    }

    @Override
    public int insertElevatorStatus(ElevatorStatus elevatorStatus) {
        return elevatorStatusMapper.insertElevatorStatus(elevatorStatus);
    }

    @Override
    public int saveElevatorStatus(ElevatorStatus elevatorStatus) {

            int count = elevatorStatusMapper.insertElevatorStatus(elevatorStatus);
            return count;
        }

    @Override
    public int checkElevatorStatusUnique(String elevator_number) {
        int count = elevatorStatusMapper.checkElevatorStatusUnique(elevator_number);
        if (count > 0)
        {
            return 1;
        }
        return 0;
    }

	@Override
	public List<String> findAllregistrationCode() {
		return elevatorStatusMapper.findAllregistrationCode();
	}

	@Override
	public List<ElevatorStatus> selectIotDevice() {
		return elevatorStatusMapper.selectIotDevice();
	}
}
