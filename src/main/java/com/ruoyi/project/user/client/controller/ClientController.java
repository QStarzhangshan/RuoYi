package com.ruoyi.project.user.client.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.user.client.domain.Client;
import com.ruoyi.project.user.client.service.ClientService;
import com.ruoyi.project.user.sale.domain.Sale;
import com.ruoyi.project.user.sale.service.SaleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Client表单构建
 *
 * @author ZH
 */
@Controller
@RequestMapping("/user/client")
public class ClientController extends BaseController {
    private String prefix = "user/client";

    @Autowired
    private ClientService clientService;

    @RequiresPermissions("user:client:view")
    @GetMapping()
    public String build() {
        return prefix + "/client";
    }
    @RequiresPermissions("user:client:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Client client)
    {
        startPage();
        List<Client> list = clientService.selectClientList(client);
        System.out.println("--------->"+list);
        return getDataTable(list);
    }
    /**
     * 新增客户
     */
    @RequiresPermissions("user:client:add")
    @Log(title = "客户管理", action = "销售管理-新增客户")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 客户保存
     */
    @RequiresPermissions("user:client:save")
    @Log(title = "销售管理", action = "客户管理-客户保存")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message save(Client client)
    {
        if (clientService.saveClient(client) > 0)
        {

            return Message.success();
        }
        return Message.error();
    }

    /**
     * 销售修改
     */
    @RequiresPermissions("user:client:edit")
    @Log(title = "客户修改 ", action = "销售情况-客户修改")
    @GetMapping("/edit/{clientId}")
    public String edit(@PathVariable("clientId") Long clientId, Model model)
    {
        Client client = clientService.selectClientById(clientId);
        model.addAttribute("client", client);
        return prefix + "/edit";
    }


    /**
     * 校验销售名
     */
    @PostMapping("/checkClientNameUnique")
    @ResponseBody
    public int checkSaleNameUnique(Client client)
    {
        int uniqueFlag = 0;
        if (client != null)
        {
            uniqueFlag = clientService.checkClientNameUnique(client.getClientName());
        }
        return uniqueFlag;
    }
}