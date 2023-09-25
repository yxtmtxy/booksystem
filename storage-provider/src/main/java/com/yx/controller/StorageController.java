package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Inventory;
import com.yx.pojo.Storage;
import com.yx.service.InventoryService;
import com.yx.service.StorageService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class StorageController {
    @Autowired
    private InventoryService inventoryService;



    /**
     * 查询所有数据
     */
    @RequestMapping("/inventoryAll")
    @ResponseBody
    public DataInfo queryInventoryAll(Inventory inventory, @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Inventory> pageInfo = inventoryService.queryInventoryAll(inventory,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @Autowired
    private StorageService storageService;

    /**
     * 跳转管理页面
     */


    /**
     * 查询所有数据
     */
    @RequestMapping("/storageAll")
    @ResponseBody
    public DataInfo queryStorageAll(Storage storage, @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Storage> pageInfo = storageService.queryStorageAll(storage,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addStorageSubmit")
    @ResponseBody
    public DataInfo addStorageSubmit(@RequestBody Storage storage){
        storageService.addStorageSubmit(storage);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryStorageById")
    @ResponseBody
    public Storage queryStorageById(@RequestParam("id") Integer id){
        return  storageService.queryStorageById(id);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateStorageSubmit")
    @ResponseBody
    public DataInfo updateStorageSubmit(@RequestBody Storage storage){
        storageService.updateStorageSubmit(storage);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteStorage")
    @ResponseBody
    public DataInfo deleteStorage(@RequestParam("ids") String ids){
        List<String> list= Arrays.asList(ids.split(","));
        storageService.deleteStorageByIds(list);
        return DataInfo.ok();
    }

}
