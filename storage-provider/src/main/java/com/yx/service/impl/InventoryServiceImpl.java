package com.yx.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.InventoryMapper;
import com.yx.pojo.Inventory;
import com.yx.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper InventoryMapper;

    @Override
    public PageInfo<Inventory> queryInventoryAll(Inventory inventory, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Inventory> InventoryList = InventoryMapper.queryInventoryAll(inventory);
        return new PageInfo<>(InventoryList) ;
    }

    @Override
    public Inventory queryInventoryById(Integer bookId) {
        return InventoryMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public void updateInventorySubmit(Inventory Inventory) {
        InventoryMapper.updateByPrimaryKey(Inventory);
    }

}
