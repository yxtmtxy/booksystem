package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.OfficerInfo;
import com.yx.service.OfficerInfoService;
import com.yx.utils.DataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//教务处人员管理
@Controller
public class OfficerInfoController {

    @Autowired
    private OfficerInfoService officerInfoService;

    /**
     * 查询所有数据
     */
    @RequestMapping("/officerAll")
    @ResponseBody
    public DataInfo queryOfficerAll(OfficerInfo officerInfo, @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<OfficerInfo> pageInfo = officerInfoService.queryOfficerInfoAll(officerInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加页面提交
     */
    @RequestMapping("/addOfficerSubmit")
    @ResponseBody
    public DataInfo addOfficerSubmit(@RequestBody OfficerInfo officerInfo){
        officerInfo.setPassword("123456");//设置默认密码
        officerInfoService.addOfficerInfoSubmit(officerInfo);
        return DataInfo.ok();
    }

    /**
     * 根据id查询数据再跳转到修改页面
     */
    @GetMapping("/queryOfficerInfoById")
    @ResponseBody
    public OfficerInfo queryOfficerInfoById(@RequestParam("offId") Integer offId){
        return officerInfoService.queryOfficerInfoById(offId);
    }

    /**
     * 修改提交
     */
    @RequestMapping("/updateOfficerSubmit")
    @ResponseBody
    public DataInfo updateOfficerSubmit(@RequestBody OfficerInfo officerInfo){
        officerInfoService.updateOfficerInfoSubmit(officerInfo);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteOfficer")
    @ResponseBody
    public DataInfo deleteOfficer(@RequestParam("offIds") String offIds){
        List<String> list= Arrays.asList(offIds.split(","));
        officerInfoService.deleteOfficerInfoByIds(list);
        return DataInfo.ok();
    }

}
