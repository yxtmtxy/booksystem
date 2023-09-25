package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Inventory;

public interface InventoryService {

    /**
     * 查询所有教材信息（分页）
     */
    PageInfo<Inventory> queryInventoryAll(Inventory inventory,Integer pageNum,Integer limit);

    /**
     * 根据id查询（修改）
     */
    Inventory queryInventoryById(Integer bookId);

    void updateInventorySubmit(Inventory inventory);


}