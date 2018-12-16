package com.ruoyi.project.elevator.status.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.elevator.car_wing.domain.Car_wing;
import com.ruoyi.project.elevator.car_wing.service.Car_wingService;
import com.ruoyi.project.elevator.engine.domain.Engine;
import com.ruoyi.project.elevator.engine.service.EngineService;
import com.ruoyi.project.elevator.pit.domain.Pit;
import com.ruoyi.project.elevator.pit.service.PitService;
import com.ruoyi.project.elevator.service.domain.Service;
import com.ruoyi.project.elevator.service.service.ServiceService;
import com.ruoyi.project.elevator.status.domain.ElevatorStatus;
import com.ruoyi.project.elevator.status.domain.Maintenance;
import com.ruoyi.project.elevator.status.service.ElevatorStatusService;
import com.ruoyi.project.elevator.status.service.MaintenanceService;
import com.ruoyi.project.elevator.well_road.domain.Well_road;
import com.ruoyi.project.elevator.well_road.service.Well_roadService;

@Controller
@RequestMapping("/elevator/status")
public class ElevatorStatusController extends BaseController {

    private String prefix = "elevator/status";

    @Autowired
    private ElevatorStatusService elevatorStatusService;
    @Autowired
    private EngineService engineService;

    @Autowired
    private MaintenanceService maintenanceService;
    
    @Autowired
    private Car_wingService car_wingService;

    @Autowired
    private Well_roadService well_roadService;

    @Autowired
    private PitService pitService;

    @Autowired
    private ServiceService serviceService;

    @RequiresPermissions("elevator:status:view")
    @GetMapping()
    public String build() {
        return prefix + "/status";
    }
    @RequiresPermissions("elevator:status:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(ElevatorStatus elevatorStatus)
    {
        startPage();
        List<ElevatorStatus> list = elevatorStatusService.selectElevatorStatusList(elevatorStatus);
        System.out.println("--------->"+list.toString());
        return getDataTable(list);
    }

    /**
     * 新增运行电梯
     */
    @RequiresPermissions("elevator:status:add")
    @Log(title = "维保管理", action = "电梯状态-电梯增加")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 电梯资料保存
     */
    @RequiresPermissions("elevator:status:save")
    @Log(title = "维保管理", action = "电梯状态-电梯资料保存")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message save(ElevatorStatus elevatorStatus)
    {
        if (elevatorStatusService.saveElevatorStatus(elevatorStatus) > 0)
        {

            return Message.success();
        }
        return Message.error();
    }

    /**
     * 校验销售名
     */
    @PostMapping("/checkElevatorStatusUnique")
    @ResponseBody
    public int checkSaleNameUnique(ElevatorStatus elevatorStatus)
    {
        int uniqueFlag = 0;
        if (elevatorStatus != null)
        {
            uniqueFlag = elevatorStatusService.checkElevatorStatusUnique(elevatorStatus.getElevator_number());
        }
        return uniqueFlag;
    }

    /**
     * 指派任务
     */
    @RequiresPermissions("elevator:status:appoint")
    @Log(title = "维保管理 ", action = "电梯状态-指派任务")
    @GetMapping("/appoint/{id}")
    public String edit(@PathVariable("id") Long id, Model model)
    {
        ElevatorStatus elevatorStatus = elevatorStatusService.selectElevatorStatusByUserName(id);
        model.addAttribute("elevatorStatus", elevatorStatus);
        return prefix + "/edit";
    }

    /**
     * 修改电梯信息
     */
//  @RequiresPermissions("elevator:status:modify")
    @Log(title="维保管理",action="电梯状态-修改信息")
    @GetMapping("/modify/{id}")
    @ResponseBody
    public ElevatorStatus modify(@PathVariable("id")Long id, Model model) {
    	ElevatorStatus elevatorStatus = elevatorStatusService.selectElevatorStatusByUserName(id);
        //Service service = serviceService.selectServiceByServiceId(id);
        model.addAttribute("elevatorStatus", elevatorStatus);
        //model.addAttribute("ServiceStatus", service);
//      return model;
        System.out.println(model);
        return elevatorStatus;
//        return prefix + "/modify";
    }
    
    /**
     * 保存修改信息
     */
    
    
    /**
     * 查看信息
     */
    @RequiresPermissions("elevator:status:see")
    @Log(title = "维保管理 ", action = "电梯状态-查看信息")
    @GetMapping("/see/{id}")
    public String see(@PathVariable("id") Long id, Model model)
    {
        ElevatorStatus elevatorStatus = elevatorStatusService.selectElevatorStatusByUserName(id);
        Maintenance maintenance = maintenanceService.selectMaintenanceById(id);
        //Service service = serviceService.selectServiceByServiceId(id);
        model.addAttribute("elevatorStatus", elevatorStatus);
        model.addAttribute("maintenance", maintenance);
        System.out.println("---------1212"+model);
        return prefix + "/see";
    }


    /**
     * 指派任务
     */
    @RequiresPermissions("elevator:status:save")
    @Log(title = "维保管理", action = "电梯状态-指派任务")
    @PostMapping("/appoint")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message appoint(Service service)
    {
        if (serviceService.saveTask(service)   > 0)
        {
            int taskId = serviceService.selectTaskById(service.getService_id());
            Engine engine = new Engine();
            engine.setService_id(taskId);
            engine.setUser_number(service.getUser_number());
            engineService.insertEngine(engine);

            Car_wing car_wing = new Car_wing();
            car_wing.setService_id(((long) taskId));
            car_wing.setUser_number(service.getUser_number());
            car_wingService.insertCarWing(car_wing);

            Well_road well_road = new Well_road();
            well_road.setService_id(((long) taskId));
            well_road.setUser_number(service.getUser_number());
            well_roadService.insertWell_road(well_road);

            Pit pit = new Pit();
            pit.setService_id(((long) taskId));
            pit.setUser_number(service.getUser_number());
            pitService.insertPit(pit);
            System.out.println("------------------->"+taskId);
            return Message.success();
        }
        return Message.error();
    }
}
