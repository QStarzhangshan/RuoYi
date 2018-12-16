package com.ruoyi.project.elevator.location.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.elevator.location.domain.Location;
import com.ruoyi.project.elevator.location.service.LocationService;
import com.ruoyi.project.elevator.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/elevator/location")
public class LocationController extends BaseController {

    private String prefix = "/elevator/location";

    @Autowired
    private MemberService memberService;

    @RequiresPermissions("elevator:location:view")
    @GetMapping()
    public String build() {
        return prefix + "/location";
    }

}
