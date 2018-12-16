package com.ruoyi.project.elevator.engine.service;

import com.ruoyi.project.elevator.engine.domain.Engine;
import com.ruoyi.project.elevator.engine.mapper.EngineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EngineService")
public class EngineServiceImpl implements EngineService{

    @Autowired
    private EngineMapper engineMapper;

    @Override
    public int insertEngine(Engine engine) {
        return engineMapper.insertEngine(engine);
    }
}
