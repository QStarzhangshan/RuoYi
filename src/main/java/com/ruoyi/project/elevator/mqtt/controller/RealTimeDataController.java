package com.ruoyi.project.elevator.mqtt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.elevator.mqtt.domain.IotDevice;
import com.ruoyi.project.elevator.mqtt.domain.RealTimeData;
import com.ruoyi.project.elevator.mqtt.service.RealTimeDataService;
import com.ruoyi.project.elevator.service.domain.Service;
import com.ruoyi.project.elevator.status.domain.ElevatorStatus;
import com.ruoyi.project.elevator.status.service.ElevatorStatusService;
import com.ruoyi.project.system.user.domain.User;

@Controller
@RequestMapping("/realtime/data")
public class RealTimeDataController extends BaseController{

	private String prefix = "realtime/data";
	
	@Autowired
	private ElevatorStatusService elevatorStatusService;
	
	@Autowired
	private RealTimeDataService realTimeDataService;
	
	@RequiresPermissions("system:realtime:data")
    @GetMapping()
    public String user()
    {
        return prefix + "/data";
    }
	
	 //初始加载的 不需要再前端做处理
    @RequiresPermissions("system:realtime:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<ElevatorStatus> list = elevatorStatusService.selectIotDevice();
        System.out.println("--------->"+list.toString());
        return getDataTable(list);
    }
    
    /**
     * 新增IOT设备
     */
    @RequiresPermissions("system:realtime:add")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }
//    /**
//     * 查看某个电梯的运行状态
//     * @param id
//     * @param model
//     * @return
//     */ 
  
    @RequiresPermissions("system:realtime:see")
    @GetMapping("/see/{id}")
    public String see(@PathVariable("id") Long id, Model model,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
    {
    	RealTimeData realTimeData = realTimeDataService.seestatus(id);
    	httpServletRequest.getSession().setAttribute("id", id);
    	System.out.println((long) httpServletRequest.getSession().getAttribute("id"));
    	model.addAttribute("data", realTimeData);
    	System.out.println(realTimeData);
    	System.out.println(model);
    	return prefix + "/see";
    }
    
//    /**
//     * 查看某个电梯的运行状态
//     * @param id
//     * @param model
//     * @return
//     */ 
//    @RequiresPermissions("system:realtime:see")
//    @GetMapping("/see")
//    public String see(Model model)
//    {
//    	/*RealTimeData realTimeData = realTimeDataService.seestatus(id);
//        model.addAttribute("data", realTimeData);
//    	System.out.println(realTimeData);*/
//    	//model.addAttribute("data", "~~~~~~~~~~~~~~~~~");
//    	//System.out.println(model);
//    	return prefix + "/see";
//    }
   
    @RequiresPermissions("system:realtime:seedata")
    @GetMapping("/seedata")
    @ResponseBody
    public RealTimeData seedate(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
//    	System.out.println(info);
//    	JSONObject obj = JSONObject.parseObject(info);
//    	long id = obj.getLongValue("id");
    	long id = (long) httpServletRequest.getSession().getAttribute("id");
    	System.out.println(id);
    	RealTimeData realTimeData = realTimeDataService.seestatus(id);
  	//  model.addAttribute("realTimeData", realTimeData);
//    	model.addAttribute("data111", "~11111~~~~~~~~~~");
    	System.out.println(realTimeData);
//    	System.out.println(model);
    	return realTimeData;
//    	return prefix + "/see";
//    	return prefix + "/see";
    }

    @RequiresPermissions("system:realtime:history")
    @GetMapping("/history")
    public String history() {
    	return prefix + "/history";
    			
    }
    
    @RequiresPermissions("system:realtime:history")
    @GetMapping("/history/{id}")
    @ResponseBody
    public TableDataInfo historysee(@PathVariable("id") Long id, Model model) {
    	startPage();
    	List<RealTimeData> realTimeDatas = realTimeDataService.seehistory(id);
    	model.addAttribute("historydata", realTimeDatas);
    	return getDataTable(realTimeDatas);
    }
    
    @PostMapping("/adddeivce")
    @ResponseBody
    public Message save(@RequestBody IotDevice iotDevice)
    {
    	System.out.println("---------111");
    	System.out.println("----------"+iotDevice);
        if (realTimeDataService.saveIotDevice(iotDevice) > 0)
        {
            return Message.success();
        }
        return Message.error();
    }
}
