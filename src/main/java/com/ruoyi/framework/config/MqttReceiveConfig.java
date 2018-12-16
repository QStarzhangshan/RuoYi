package com.ruoyi.framework.config;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.elevator.mqtt.service.RealTimeDataService;
import com.ruoyi.project.elevator.status.service.ElevatorStatusService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈MQTT接收消息处理〉
 *
 * @author lenovo
 * @create 2018/6/4
 * @since 1.0.0
 */
@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {
 
    @Value("${spring.mqtt.username}")
    private String username;
 
    @Value("${spring.mqtt.password}")
    private String password;
 
    @Value("${spring.mqtt.url}")
    private String hostUrl;
 
    @Value("${spring.mqtt.client.id}")
    private String clientId;
 
    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;
 
    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout ;   //连接超时
 
    @Autowired
    private  ElevatorStatusService elevatorStatusService;
    
    @Autowired
    private RealTimeDataService realTimeService;
    
//    public static String s = null;
    
    @Bean
    public MqttConnectOptions getMqttConnectOptions(){
        MqttConnectOptions mqttConnectOptions=new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setKeepAliveInterval(2);
        return mqttConnectOptions;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setUserName(username);
        factory.setPassword(password);
        factory.setServerURIs(hostUrl);
        return factory;
    }
 
    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }
 
    //配置client,监听的topic 
    @Bean
    public MessageProducer inbound() {
//        List<String> list = elevatorStatusService.findAllregistrationCode();
////        String... strs = null;
//        System.out.println(list);
//        String[] sss = null;
//        String ssss = "30103505002007090044,30103505002007090043";
//        StringBuffer sb = new StringBuffer();
//        for(String s : list) {
//        	if(!(s==null)) {
//        	sb.append('"'+s+'"'+",");
//        }
//        	}
//        String str = sb.toString();
//        System.out.println(str);
            MqttPahoMessageDrivenChannelAdapter adapter =
                        new MqttPahoMessageDrivenChannelAdapter(clientId+"_inbound", mqttClientFactory(),"32103505002014080045",
                        		"32103505002013010032",
                        		"31203505002015100845"
                        		);
                adapter.setCompletionTimeout(completionTimeout);
                adapter.setConverter(new DefaultPahoMessageConverter());
                adapter.setQos(1);
                adapter.setOutputChannel(mqttInputChannel());
                return adapter;
    }
 
    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        System.out.println("---------111");
    	return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
            	JSONObject obj = JSONObject.parseObject(message.getPayload().toString());
            	String current_status = obj.getString("current_status");
            	String play_way = obj.getString("play_way");
            	String door_status = obj.getString("door_status");
            	String current_rank = obj.getString("current_rank");
            	String play_direction = obj.getString("play_direction");
            	String play_speed = obj.getString("play_speed");
            	String topic = message.getHeaders().get("mqtt_topic").toString();
                String type = topic.substring(topic.lastIndexOf("/")+1, topic.length());
                System.out.println(current_status);
                System.out.println("hello,QSTART,"+message.getPayload().toString());
                System.out.println(topic);
                realTimeService.insertData(topic,current_status,play_way,door_status,current_rank,play_direction,play_speed);
//                List<String> str = elevatorStatusService.findAllregistrationCode();
//                String s = null;
//                if("aaaa".equalsIgnoreCase(topic)){
//                    System.out.println("hello,QSTART,"+message.getPayload().toString());
//                
////                }else if("hello1".equalsIgnoreCase(topic)){
////                    System.out.println("hello1,QSTART,"+message.getPayload().toString());
////                }
//                }
            }
        };
    }
}


