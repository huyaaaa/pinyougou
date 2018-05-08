package com.huyaaaaaa.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huyaaaaaa.manager.service.BrandService;
import com.huyaaaaaa.mapper.TbBrandMapper;
import com.huyaaaaaa.pojo.TbBrand;
import com.huyaaaaaa.pojo.TbBrandExample;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbrandMapper;
    @Override
    public List<TbBrand> findAll() {

        List<TbBrand> list = tbrandMapper.selectByExample(null);

        return list;
    }

    @Override
    public PageResult<TbBrand> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbBrand> list = tbrandMapper.selectByExample(null);
        PageInfo<TbBrand> pageInfo = new PageInfo(list);

        return new PageResult(pageInfo.getTotal(),list);
    }

    @Override
    public PygResult add(TbBrand tbBrand) {
        try {
            System.out.println(tbBrand.toString());
            tbrandMapper.insertSelective(tbBrand);
            return new PygResult(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new PygResult(false,"失败了啦啦啦啦啦啦");
        }

    }

    @Override
    public TbBrand findOne(Long id) {
//        TbBrand tbBrand = new TbBrand();
//        tbBrand.setId(id);
        TbBrand tbBrand = tbrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    @Override
    public PygResult update(TbBrand tbBrand) {
        try {
            tbrandMapper.updateByPrimaryKeySelective(tbBrand);
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
                tbrandMapper.deleteByPrimaryKey(id);
                }
                return new PygResult(true,"删除成功");

            } catch (Exception e) {
                e.printStackTrace();
                return new PygResult(false,"删除失败了，后台报了错");
            }

    }

    @Override
    public PageResult<TbBrand> search(Integer pageNum, Integer pageSize, String searchStr) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();

        if (searchStr != null && searchStr.length() == 1){
            //当输入单字符的时候，创建两个criteria查询首字母和名字两列符合的结果
            TbBrandExample.Criteria criteriaOr = example.or();
            criteria.andFirstCharEqualTo(searchStr.toUpperCase());
            criteriaOr.andNameLike("%"+searchStr+"%");

        }else if (searchStr != null && searchStr.length()>1){
            //当输入大于一个字符时，肯定不是首字母了。只查询名字符合就行了
            criteria.andNameLike("%"+searchStr+"%");
        }

        List<TbBrand> tbBrands = tbrandMapper.selectByExample(example);
        PageInfo<TbBrand> pageInfo = new PageInfo<>(tbBrands);
        return new PageResult<TbBrand>(pageInfo.getTotal(),tbBrands);
    }


}
