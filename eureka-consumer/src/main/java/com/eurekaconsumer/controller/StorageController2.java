package com.eurekaconsumer.controller;

import com.eurekaconsumer.pojo.Inventory;
import com.eurekaconsumer.pojo.Storage;
import com.eurekaconsumer.service.StorageService2;
import com.eurekaconsumer.service.queryService;
import com.eurekaconsumer.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller

public class StorageController2 {
    @Autowired
    private StorageService2 storageService2;
    @Autowired
    private queryService queryService;

    @GetMapping("/inventoryIndex")
    public String inventoryIndex(){
        return "storage/inventoryIndex";
    }
    @GetMapping("/storageIndex")
    public String storageIndex(){
        return "storage/storageIndex";
    }

    @RequestMapping("/storageAdd")
    public String storageAdd(){
        return "storage/storageAdd";
    }

    @RequestMapping("/inventoryAll")
    @ResponseBody
    public DataInfo queryInventoryAll(Inventory inventory, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Inventory> pageInfo = queryService.queryInventoryAll(inventory,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/storageAll")
    @ResponseBody
    public DataInfo queryStorageAll(Storage storage, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<Storage> pageInfo = queryService.queryStorageAll(storage,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/addStorageSubmit")
    @ResponseBody
    public DataInfo addStorageSubmit(@RequestBody Storage storage){
        return storageService2.addStorageSubmit(storage);
    }

    @GetMapping("/queryStorageById")
    public String queryStorageById(@RequestParam("id") Integer id, Model model){
        Storage storage = storageService2.queryStorageById(id);
        model.addAttribute("info",storage);
        return "storage/updateStorage";
    }

    @RequestMapping("/updateStorageSubmit")
    @ResponseBody
    public DataInfo updateStorageSubmit(@RequestBody Storage storage){
        return storageService2.updateStorageSubmit(storage);
    }

    @RequestMapping("/deleteStorage")
    @ResponseBody
    public DataInfo deleteStorage(@RequestParam("ids") String ids){
        return storageService2.deleteStorage(ids);
    }





}
