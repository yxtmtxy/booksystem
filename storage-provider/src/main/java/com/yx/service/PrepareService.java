package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Prepare;

public interface PrepareService {

    /**
     * 查询所有信息（分页）
     */
    PageInfo<Prepare> queryPrepareAll(Prepare prepare,Integer pageNum,Integer limit);

    void updateNum(Integer num);

    /**
     * 根据id查询（修改）
     */
    Prepare queryPrepareById(Integer id);

    /**
     * 修改提交
     */
    void updatePrepareSubmit(Prepare prepare);

}