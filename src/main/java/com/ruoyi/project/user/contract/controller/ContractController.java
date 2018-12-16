package com.ruoyi.project.user.contract.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.user.contract.domain.Contract;
import com.ruoyi.project.user.contract.service.ContractService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/contract")
public class ContractController extends BaseController {

    private String prefix = "user/contract";

    @Autowired
    private ContractService contractService;

    @RequiresPermissions("user:contract:view")
    @GetMapping()
    public String sale()
    {
        return prefix + "/contract";
    }

    @RequiresPermissions("user:contract:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Contract contract)
    {
        startPage();
        List<Contract> list = contractService.selectContractList(contract);
        System.out.println("--------->"+list);
        return getDataTable(list);
    }
    /**
     * 合同修改
     */
    @RequiresPermissions("user:contract:edit")
    @Log(title = "合同修改 ", action = "合同修改-合同修改")
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, Model model)
    {
        Contract contract = contractService.selectContractById(contractId);
        model.addAttribute("contract", contract);
        return prefix + "/edit";
    }
    /**
     * 新增合同
     */
    @RequiresPermissions("user:contract:add")
    @Log(title = "合同管理", action = "合同管理-新增合同")
    @GetMapping("/add")
    public String add(Model model) {
        return prefix + "/add";
    }

    /**
     * 合同保存
     */
    @RequiresPermissions("user:contract:save")
    @Log(title = "合同管理", action = "合同管理-合同保存")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message save(Contract contract)
    {
        if (contractService.saveContract(contract) > 0)
        {
            System.out.println("----------->");
            return Message.success();
        }
        return Message.error();
    }
    /**
     * 校验销售名
     */
    @PostMapping("/checkContractNameUnique")
    @ResponseBody
    public int checkContractNameUnique(Contract contract)
    {
        int uniqueFlag = 0;
        if (contract != null)
        {
            uniqueFlag = contractService.checkContractNameUnique(contract.getContractTopic());
        }
        return uniqueFlag;
    }
}
