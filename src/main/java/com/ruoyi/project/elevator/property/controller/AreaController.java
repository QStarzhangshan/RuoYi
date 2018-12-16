package com.ruoyi.project.elevator.property.controller;


import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.elevator.property.domain.Area;
import com.ruoyi.project.elevator.property.service.AreaService;

@Controller
@RequestMapping("/property/area")
public class AreaController extends BaseController{
	
	private String prefix = "property/area";
	
	@Autowired
	private AreaService areaService;

	@RequiresPermissions("property:area:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/area";
    }
   
	
    //初始加载的 不需要再前端做处理
    @RequiresPermissions("property:area:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Area> list = areaService.selectAreaList();
        return getDataTable(list);
    }
	
	
    /**
     * 新增小区
     */
    @RequiresPermissions("property:area:add")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

	
//	@RequiresPermissions("elevator:status:save")
    @Log(title = "维保管理", action = "电梯状态-电梯资料保存")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message save(Area area)
    {
        if (areaService.saveArea(area) > 0)
        {

            return Message.success();
        }
        return Message.error();
    }
	
}
