package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.ReceiveStu;
import com.yx.pojo.ReceiveTea;
import java.util.List;

public interface ReceiveService {

    /**
     * 查询所有信息（分页）
     */
    PageInfo<ReceiveStu> queryReceiveStuAll(Integer stuId,ReceiveStu receiveStu,Integer pageNum,Integer limit,Integer bookId, Integer type);
    /**
     * 查询所有信息（分页）
     */
    PageInfo<ReceiveTea> queryReceiveTeaAll(Integer teaId,ReceiveTea receiveTea,Integer pageNum,Integer limit,Integer bookId, Integer type);

    /**
     * 根据id查询（修改）
     */
    ReceiveStu queryReceiveStuById(Integer id);
    /**
     * 根据id查询（修改）
     */
    ReceiveTea queryReceiveTeaById(Integer id);

    /**
     * 修改提交
     */
    void updateReceiveStuSubmit(ReceiveStu receiveStu);
    /**
     * 修改提交
     */
    void updateReceiveTeaSubmit(ReceiveTea receiveTea);

    /**
     * 删除
     */
    void deleteReceiveStuByIds(List<String> ids);
    /**
     * 删除
     */
    void deleteReceiveTeaByIds(List<String> ids);
}