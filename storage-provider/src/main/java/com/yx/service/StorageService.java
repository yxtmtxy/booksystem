package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Storage;

import java.util.List;

public interface StorageService {

    /**
     * 查询所有教材信息（分页）
     */
    PageInfo<Storage> queryStorageAll(Storage storage,Integer pageNum,Integer limit);

    /**
     * 添加提交
     */
    void addStorageSubmit(Storage storage);

    /**
     * 根据id查询（修改）
     */
    Storage queryStorageById(Integer id);

    /**
     * 修改提交
     */
    void updateStorageSubmit(Storage storage);

    /**
     * 删除
     */
    void deleteStorageByIds(List<String> ids);

}