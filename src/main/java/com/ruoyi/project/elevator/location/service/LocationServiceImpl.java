package com.ruoyi.project.elevator.location.service;

import com.ruoyi.project.elevator.location.domain.Location;
import com.ruoyi.project.elevator.location.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LocationService")
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> getLocation() {
        return locationMapper.getLocation();
    }
}
