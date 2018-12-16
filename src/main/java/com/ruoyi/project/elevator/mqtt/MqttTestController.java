package com.ruoyi.project.elevator.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Mqtt")
public class MqttTestController {
 
    @Autowired
    private MqttGateway mqttGateway;
 
    @RequestMapping("/sendMqtt")
    public String sendMqtt(String  sendData){
        mqttGateway.sendToMqtt(sendData,"hello");
        return "OK";
    }
}

