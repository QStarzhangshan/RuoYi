package com.ruoyi.project.elevator.member.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.elevator.member.domain.Member;
import com.ruoyi.project.elevator.member.service.MemberService;
import com.ruoyi.project.elevator.status.domain.ElevatorStatus;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/elevator/member")
public class MemberController extends BaseController{

    private String prefix = "/elevator/member";

    @Autowired
    private MemberService memberService;

    @RequiresPermissions("elevator:member:view")
    @GetMapping()
    public String build() {
        return prefix + "/member";
    }
    @RequiresPermissions("elevator:member:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Member member)
    {
        startPage();
        List<Member> list = memberService.selectMemberList(member);
        return getDataTable(list);
    }

}
