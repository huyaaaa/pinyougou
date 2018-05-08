package com.huyaaaaaa.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyaaaaaa.manager.service.SpecificationService;
import com.huyaaaaaa.mapper.TbSpecificationMapper;
import com.huyaaaaaa.mapper.TbSpecificationOptionMapper;
import com.huyaaaaaa.pojo.TbSpecification;
import com.huyaaaaaa.pojo.TbSpecificationExample;
import com.huyaaaaaa.pojo.TbSpecificationOption;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import com.huyaaaaaa.vo.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;
    @Override
    public List<TbSpecification> findAll() {
        System.out.println("test-1");
        List<TbSpecification> list = tbSpecificationMapper.selectByExample(null);

        return list;
    }

    @Override
    public PageResult<TbSpecification> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbSpecification> list = tbSpecificationMapper.selectByExample(null);
        PageInfo<TbSpecification> pageInfo = new PageInfo(list);

        return new PageResult(pageInfo.getTotal(),list);
    }

    @Override
    public PygResult add(Specification specification) {
        try {
            //保存规格
            TbSpecification tbSpecification = specification.getTbSpecification();
            tbSpecificationMapper.insertSelective(tbSpecification);
            //保存规格选项
            List<TbSpecificationOption> list = specification.getList();
            for (TbSpecificationOption tbSpecificationOption : list) {
                tbSpecificationOption.setSpecId(tbSpecification.getId());
                tbSpecificationOptionMapper.insertSelective(tbSpecificationOption);
            }

            return new PygResult(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new PygResult(false,"失败了啦啦啦啦啦啦");
        }

    }

    @Override
    public TbSpecification findOne(Long id) {
//        TbSpecification tbSpecification = new TbSpecification();
//        tbSpecification.setId(id);
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        return tbSpecification;
    }

    @Override
    public PygResult update(Specification specification) {
        try {
            TbSpecification tbSpecification = specification.getTbSpecification();
            tbSpecificationMapper.insertSelective(tbSpecification);
            //保存规格选项
            List<TbSpecificationOption> list = specification.getList();
            for (TbSpecificationOption tbSpecificationOption : list) {
                tbSpecificationOption.setSpecId(tbSpecification.getId());
                tbSpecificationOptionMapper.insertSelective(tbSpecificationOption);
            }
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
                tbSpecificationMapper.deleteByPrimaryKey(id);
                }
                return new PygResult(true,"删除成功");

            } catch (Exception e) {
                e.printStackTrace();
                return new PygResult(false,"删除失败了，后台报了错");
            }

    }

    @Override
    public PageResult<TbSpecification> search(Integer pageNum, Integer pageSize, String searchStr) {
        PageHelper.startPage(pageNum,pageSize);
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();

        if (searchStr != null && searchStr!= ""){
            criteria.andSpecNameLike("%"+searchStr+"%");
        }
        List<TbSpecification> tbSpecifications = tbSpecificationMapper.selectByExample(example);
        PageInfo<TbSpecification> pageInfo = new PageInfo<>(tbSpecifications);
        return new PageResult<TbSpecification>(pageInfo.getTotal(),tbSpecifications);
    }

    @Override
    public List<Map> selectSpecMapList() {
        List<Map> mapList = tbSpecificationMapper.selectSpecMapList();
        return mapList;

    }


}
