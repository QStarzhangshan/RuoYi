package com.ruoyi.project.elevator.pit.service;

import com.ruoyi.project.elevator.pit.domain.Pit;
import com.ruoyi.project.elevator.pit.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitServiceImpl implements PitService{

	@Autowired
	private PitMapper pitMapper;

	@Override
	public int insertPit(Pit pit) {
		return pitMapper.insertPit(pit);
	}
}
