package com.yx.service.impl;
import com.yx.dao.StorageMapper;
import com.yx.pojo.Storage;
import com.yx.service.StorageService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StorageService")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper StorageMapper;

    @Override
    public PageInfo<Storage> queryStorageAll(Storage storage, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Storage> StorageList = StorageMapper.queryStorageAll(storage);
        return new PageInfo<>(StorageList) ;
    }

    @Override
    public void addStorageSubmit(Storage storage) {
        StorageMapper.insert(storage);
    }

    @Override
    public Storage queryStorageById(Integer id) {
        return StorageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateStorageSubmit(Storage Storage) {
        StorageMapper.updateByPrimaryKey(Storage);
    }

    @Override
    public void deleteStorageByIds(List<String> ids) {
        for (String id : ids){
            StorageMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
