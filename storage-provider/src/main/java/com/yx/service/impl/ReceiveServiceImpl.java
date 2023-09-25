package com.yx.service.impl;
import com.yx.dao.ReceiveStuMapper;
import com.yx.dao.ReceiveTeaMapper;
import com.yx.pojo.ReceiveStu;
import com.yx.pojo.ReceiveTea;
import com.yx.service.ReceiveService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReceiveService")
public class ReceiveServiceImpl implements ReceiveService {

    @Autowired
    private ReceiveStuMapper ReceiveStuMapper;
    @Autowired
    private ReceiveTeaMapper ReceiveTeaMapper;

    @Override
    public PageInfo<ReceiveStu> queryReceiveStuAll(Integer stuId,ReceiveStu receiveStu, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ReceiveStu> ReceiveStuList = ReceiveStuMapper.queryReceiveStuAll(receiveStu,stuId,bookId,type);
        return new PageInfo<>(ReceiveStuList) ;
    }
    @Override
    public PageInfo<ReceiveTea> queryReceiveTeaAll(Integer teaId,ReceiveTea receiveTea, Integer pageNum, Integer limit,Integer bookId, Integer type) {
        PageHelper.startPage(pageNum,limit);
        List<ReceiveTea> ReceiveTeaList = ReceiveTeaMapper.queryReceiveTeaAll(receiveTea,teaId,bookId,type);
        return new PageInfo<>(ReceiveTeaList) ;
    }


    @Override
    public ReceiveStu queryReceiveStuById(Integer id) {
        return ReceiveStuMapper.selectByPrimaryKey(id);
    }
    @Override
    public ReceiveTea queryReceiveTeaById(Integer id) {
        return ReceiveTeaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateReceiveStuSubmit(ReceiveStu ReceiveStu) {
        ReceiveStuMapper.updateByPrimaryKey(ReceiveStu);
    }
    @Override
    public void updateReceiveTeaSubmit(ReceiveTea ReceiveTea) {
        ReceiveTeaMapper.updateByPrimaryKey(ReceiveTea);
    }

    @Override
    public void deleteReceiveStuByIds(List<String> ids) {
        for (String id : ids){
            ReceiveStuMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
    @Override
    public void deleteReceiveTeaByIds(List<String> ids) {
        for (String id : ids){
            ReceiveTeaMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
