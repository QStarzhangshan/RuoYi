package com.ruoyi.project.elevator.service.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.elevator.service.domain.Service;
import com.ruoyi.project.elevator.service.service.ServiceService;
import com.ruoyi.project.elevator.status.domain.ElevatorStatus;
import com.ruoyi.project.elevator.status.service.ElevatorStatusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/elevator/statistics")
public class ServiceController extends BaseController {

    private String prefix = "/elevator/statistics";

    @Autowired
    private ServiceService serviceService;

    @RequiresPermissions("elevator:statistics:view")
    @GetMapping()
    public String build() {
        return prefix + "/service";
    }
    @RequiresPermissions("elevator:statistics:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Service service)
    {
        startPage();
        List<Service> list = serviceService.selectServiceList(service);
        System.out.println("--------->"+list.toString());
        return getDataTable(list);
    }

    /**
     * 新增运行电梯
     */
    @RequiresPermissions("elevator:statistics:add")
    @Log(title = "维保管理", action = "电梯状态-电梯增加")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }
    /**
     * 修改
     */
        @RequiresPermissions("elevator:statistics:edit")
        @Log(title = "维保管理 ", action = "维保服务-修改")
        @GetMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model model)
        {
            Service service = serviceService.selectServiceById(id);
            model.addAttribute("service", service);
            return prefix + "/edit";
        }
    /**
     * 电梯资料保存
     */
    /*
    @RequiresPermissions("elevator:statistics:save")
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

    *//**
     * 校验销售名
     *//*
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
     *//*
    @RequiresPermissions("elevator:status:save")
    @Log(title = "维保管理", action = "电梯状态-指派任务")
    @PostMapping("/appoint")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message appoint(Service statistics)
    {
        if (serviceService.saveTask(statistics)   > 0)
        {

            return Message.success();
        }
        return Message.error();
    }*/
}
