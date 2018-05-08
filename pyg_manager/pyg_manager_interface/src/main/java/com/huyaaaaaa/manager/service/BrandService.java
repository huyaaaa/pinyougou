package com.huyaaaaaa.manager.service;

import com.huyaaaaaa.pojo.TbBrand;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    List<TbBrand> findAll();
    PageResult<TbBrand> findPage(Integer pageNum,Integer pageSize);
    PygResult add(TbBrand tbBrand);

    TbBrand findOne(Long id);


    PygResult update(TbBrand tbBrand);

    PygResult delete(Long[] ids);

    PageResult<TbBrand> search(Integer page, Integer rows, String searchStr);

    List<Map> selectBrandMapList();
}
