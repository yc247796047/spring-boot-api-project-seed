package com.company.project.service.impl;

import com.company.project.dao.TbAreaMapper;
import com.company.project.model.TbArea;
import com.company.project.service.TbAreaService;
import com.company.project.core.AbstractService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/05.
 */
@Service
@Transactional
public class TbAreaServiceImpl extends AbstractService<TbArea> implements TbAreaService {
    @Resource
    private TbAreaMapper tbAreaMapper;

    @Autowired
    private TbAreaService tbAreaService;

    @Override
    public int save(TbArea model)   {

            model.setCreateTime(new Date());
            model.setLastEditTime(new Date());
            return super.save(model);

    }

    @Override
    public void save(List<TbArea> models) {
        super.save(models);
    }

    @Override
    public int deleteById(Integer id) {
        return super.deleteById(id);
    }

    @Override
    public void deleteByIds(String ids) {
        super.deleteByIds(ids);
    }

    @Override
    public int update(TbArea model) {
        model.setLastEditTime(new Date());
        return super.update(model);
    }

    @Override
    public TbArea findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public TbArea findBy(String fieldName, Object value) throws TooManyResultsException {
        return super.findBy(fieldName, value);
    }

    @Override
    public List<TbArea> findByIds(String ids) {
        return super.findByIds(ids);
    }

    @Override
    public List<TbArea> findByCondition(Condition condition) {
        return super.findByCondition(condition);
    }

    @Override
    public List<TbArea> findAll() {
        return super.findAll();
    }
}
