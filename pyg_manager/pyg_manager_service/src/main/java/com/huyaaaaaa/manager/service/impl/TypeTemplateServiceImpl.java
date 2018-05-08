package com.huyaaaaaa.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyaaaaaa.manager.service.TypeTemplateService;
import com.huyaaaaaa.mapper.TbTypeTemplateMapper;
import com.huyaaaaaa.pojo.TbTypeTemplate;
import com.huyaaaaaa.pojo.TbTypeTemplateExample;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;
    @Override
    public List<TbTypeTemplate> findAll() {

        List<TbTypeTemplate> list = typeTemplateMapper.selectByExample(null);


        return list;
    }

    @Override
    public PageResult<TbTypeTemplate> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbTypeTemplate> list = typeTemplateMapper.selectByExample(null);
        PageInfo<TbTypeTemplate> pageInfo = new PageInfo(list);

        return new PageResult(pageInfo.getTotal(),list);
    }

    @Override
    public PygResult add(TbTypeTemplate tbTypeTemplate) {
        try {
            System.out.println(tbTypeTemplate.toString());
            typeTemplateMapper.insertSelective(tbTypeTemplate);
            return new PygResult(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new PygResult(false,"失败了啦啦啦啦啦啦");
        }

    }

    @Override
    public TbTypeTemplate findOne(Long id) {
//        TbTypeTemplate tbTypeTemplate = new TbTypeTemplate();
//        tbTypeTemplate.setId(id);
        TbTypeTemplate tbTypeTemplate = typeTemplateMapper.selectByPrimaryKey(id);
        return tbTypeTemplate;
    }

    @Override
    public PygResult update(TbTypeTemplate tbTypeTemplate) {
        try {
            typeTemplateMapper.updateByPrimaryKeySelective(tbTypeTemplate);
            return new PygResult(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new PygResult(true,"修改失败");
        }
    }

    @Override
    public PygResult delete(Long[] ids) {

            try {
                for (Long id:ids) {
                typeTemplateMapper.deleteByPrimaryKey(id);
                }
                return new PygResult(true,"删除成功");

            } catch (Exception e) {
                e.printStackTrace();
                return new PygResult(false,"删除失败了，后台报了错");
            }

    }

    @Override
    public PageResult<TbTypeTemplate> search(Integer pageNum, Integer pageSize, String searchStr) {
        PageHelper.startPage(pageNum,pageSize);
        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();


        if (searchStr != null && searchStr != "") {

            criteria.andNameLike("%" + searchStr + "%");
        }



        List<TbTypeTemplate> tbTypeTemplates = typeTemplateMapper.selectByExample(example);
        PageInfo<TbTypeTemplate> pageInfo = new PageInfo<>(tbTypeTemplates);
        return new PageResult<TbTypeTemplate>(pageInfo.getTotal(),tbTypeTemplates);
    }


}
