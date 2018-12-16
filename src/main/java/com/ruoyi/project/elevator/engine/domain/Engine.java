package com.ruoyi.project.elevator.engine.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Engine extends BaseEntity {

    private long id;
    private long service_id;
    private String user_number;
    private long traction_machine;
    private long room_environment;
    private long encoder;
    private long brakespinparts;
    private long brakesclearance;
    private long speedlimiter;
    private long operating_device;

    public Engine() {
    }

    public Engine(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public long getTraction_machine() {
        return traction_machine;
    }

    public void setTraction_machine(long traction_machine) {
        this.traction_machine = traction_machine;
    }

    public long getRoom_environment() {
        return room_environment;
    }

    public void setRoom_environment(long room_environment) {
        this.room_environment = room_environment;
    }

    public long getEncoder() {
        return encoder;
    }

    public void setEncoder(long encoder) {
        this.encoder = encoder;
    }

    public long getBrakespinparts() {
        return brakespinparts;
    }

    public void setBrakespinparts(long brakespinparts) {
        this.brakespinparts = brakespinparts;
    }

    public long getBrakesclearance() {
        return brakesclearance;
    }

    public void setBrakesclearance(long brakesclearance) {
        this.brakesclearance = brakesclearance;
    }

    public long getSpeedlimiter() {
        return speedlimiter;
    }

    public void setSpeedlimiter(long speedlimiter) {
        this.speedlimiter = speedlimiter;
    }

    public long getOperating_device() {
        return operating_device;
    }

    public void setOperating_device(long operating_device) {
        this.operating_device = operating_device;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", service_id=" + service_id +
                ", user_number='" + user_number + '\'' +
                ", traction_machine=" + traction_machine +
                ", room_environment=" + room_environment +
                ", encoder=" + encoder +
                ", brakespinparts=" + brakespinparts +
                ", brakesclearance=" + brakesclearance +
                ", speedlimiter=" + speedlimiter +
                ", operating_device=" + operating_device +
                '}';
    }
}
