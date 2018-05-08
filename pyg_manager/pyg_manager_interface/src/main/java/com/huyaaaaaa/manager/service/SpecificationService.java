package com.huyaaaaaa.manager.service;

import com.huyaaaaaa.pojo.TbSpecification;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import com.huyaaaaaa.vo.Specification;

import java.util.List;

public interface SpecificationService {
    List<TbSpecification> findAll();
    PageResult<TbSpecification> findPage(Integer pageNum, Integer pageSize);
    PygResult add(Specification specification);

    TbSpecification findOne(Long id);


    PygResult update(Specification specification);

    PygResult delete(Long[] ids);

    PageResult<TbSpecification> search(Integer page, Integer rows, String searchStr);
}
