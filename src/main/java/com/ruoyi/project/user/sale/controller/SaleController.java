package com.ruoyi.project.user.sale.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.Message;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.user.sale.domain.Sale;
import com.ruoyi.project.user.sale.service.SaleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/sale")
public class SaleController extends BaseController{

    private String prefix = "user/sale";

    @Autowired
    private SaleService saleService;

    @RequiresPermissions("user:sale:view")
    @GetMapping()
    public String sale()
    {
        return prefix + "/sale";
    }

    @RequiresPermissions("user:sale:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Sale sale)
    {
        startPage();
        List<Sale> list = saleService.selectSaleList(sale);
        System.out.println("--------->"+list);
        return getDataTable(list);
    }
    /**
     * 销售修改
     */
    @RequiresPermissions("user:sale:edit")
    @Log(title = "销售修改 ", action = "销售情况-销售修改")
    @GetMapping("/edit/{saleId}")
    public String edit(@PathVariable("saleId") Long saleId, Model model)
    {
        Sale sale = saleService.selectSaleById(saleId);
        model.addAttribute("sale", sale);
        return prefix + "/edit";
    }

    /**
     * 新增销售
     */
    @RequiresPermissions("user:sale:add")
    @Log(title = "销售管理", action = "销售管理-新增销售")
    @GetMapping("/add")
    public String add(Model model) {
        return prefix + "/add";
    }

    /**
     * 销售保存
     */
    @RequiresPermissions("user:sale:save")
    @Log(title = "销售管理", action = "销售情况-销售保存")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public Message save(Sale sale)
    {
        if (saleService.saveSale(sale) > 0)
        {
            System.out.println("----------->");
            return Message.success();
        }
        return Message.error();
    }
    /**
     * 校验销售名
     */
    @PostMapping("/checkSaleNameUnique")
    @ResponseBody
    public int checkSaleNameUnique(Sale sale)
    {
        int uniqueFlag = 0;
        if (sale != null)
        {
            uniqueFlag = saleService.checkSaleNameUnique(sale.getSaleName());
        }
        return uniqueFlag;
    }

//    @RequiresPermissions("user:sale:remove")
//    @Log(title = "销售情况", action = "销售情况-销售删除")
//    @RequestMapping("/remove/{roleId}")
//    @Transactional(rollbackFor=Exception.class)
//    @ResponseBody
//    public Message remove(@PathVariable("saleId") Long saleId)
//    {
//        Sale sale = saleService.selectSaleById(saleId);
//        if (sale == null)
//        {
//            return Message.error("角色不存在");
//        }
//        if (saleService.selectCountUserSaleBySaleId(saleId) > 0)
//        {
//            return Message.error("角色已分配,不能删除");
//        }
//        if (roleService.deleteRoleById(roleId) > 0)
//        {
//            return Message.success();
//        }
//        return Message.error();
//    }

}
