package com.huyaaaaaa.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyaaaaaa.manager.service.SpecificationOptionService;
import com.huyaaaaaa.mapper.TbSpecificationOptionMapper;
import com.huyaaaaaa.pojo.TbSpecificationOption;
import com.huyaaaaaa.pojo.TbSpecificationOptionExample;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {
    @Autowired
    private TbSpecificationOptionMapper tSpecificationOptionMapper;
    @Override
    public List<TbSpecificationOption> findAll() {

        List<TbSpecificationOption> list = tSpecificationOptionMapper.selectByExample(null);


        return list;
    }

    @Override
    public PageResult<TbSpecificationOption> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbSpecificationOption> list = tSpecificationOptionMapper.selectByExample(null);
        PageInfo<TbSpecificationOption> pageInfo = new PageInfo(list);

        return new PageResult(pageInfo.getTotal(),list);
    }

    @Override
    public PygResult add(TbSpecificationOption tbSpecificationOption) {
        try {
            System.out.println(tbSpecificationOption.toString());
            tSpecificationOptionMapper.insertSelective(tbSpecificationOption);
            return new PygResult(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new PygResult(false,"失败了啦啦啦啦啦啦");
        }

    }

    @Override
    public TbSpecificationOption findOne(Long id) {
//        TbSpecificationOption tbSpecificationOption = new TbSpecificationOption();
//        tbSpecificationOption.setId(id);
        TbSpecificationOption tbSpecificationOption = tSpecificationOptionMapper.selectByPrimaryKey(id);
        return tbSpecificationOption;
    }

    @Override
    public PygResult update(TbSpecificationOption tbSpecificationOption) {
        try {
            tSpecificationOptionMapper.updateByPrimaryKeySelective(tbSpecificationOption);
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
                tSpecificationOptionMapper.deleteByPrimaryKey(id);
                }
                return new PygResult(true,"删除成功");

            } catch (Exception e) {
                e.printStackTrace();
                return new PygResult(false,"删除失败了，后台报了错");
            }

    }

    @Override
    public PageResult<TbSpecificationOption> search(Integer pageNum, Integer pageSize, String searchStr) {
        PageHelper.startPage(pageNum,pageSize);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();

        if (searchStr != null && searchStr!="") {

            criteria.andOptionNameLike("%" + searchStr + "%");
        }

        List<TbSpecificationOption> tbSpecificationOptions = tSpecificationOptionMapper.selectByExample(example);
        PageInfo<TbSpecificationOption> pageInfo = new PageInfo<>(tbSpecificationOptions);
        return new PageResult<TbSpecificationOption>(pageInfo.getTotal(),tbSpecificationOptions);
    }

    @Override
    public List<TbSpecificationOption> findbyId(Long id) {
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> optionList = tSpecificationOptionMapper.selectByExample(example);

        return optionList;
    }

    /*@Override
    public List<Map> selectSpecificationOptionMapList() {
        List<Map> mapList = tSpecificationOptionMapper.selectSpecificationOptionMapList();
        return mapList;
    }*/


}
