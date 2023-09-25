package com.yx.service.impl;
import com.yx.dao.PrepareMapper;
import com.yx.pojo.Prepare;
import com.yx.service.PrepareService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PrepareService")
public class PrepareServiceImpl implements PrepareService {

    @Autowired
    private PrepareMapper PrepareMapper;

    @Override
    public PageInfo<Prepare> queryPrepareAll(Prepare prepare, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Prepare> PrepareList = PrepareMapper.queryPrepareAll(prepare);
        return new PageInfo<>(PrepareList) ;
    }

    @Override
    public void updateNum(Integer num){
        PrepareMapper.updateNum(num);
    }

    @Override
    public Prepare queryPrepareById(Integer id) {
        return PrepareMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePrepareSubmit(Prepare Prepare) {
        PrepareMapper.updateByPrimaryKey(Prepare);
    }

}
