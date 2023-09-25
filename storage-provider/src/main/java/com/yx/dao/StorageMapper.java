package com.yx.dao;

import com.yx.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Storage record);

    List<Storage> queryStorageAll(Storage storage);
}