package com.huyaaaaaa.manager.service;

import com.huyaaaaaa.pojo.TbSpecificationOption;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;

import java.util.List;

public interface SpecificationOptionService {
    List<TbSpecificationOption> findAll();
    PageResult<TbSpecificationOption> findPage(Integer pageNum, Integer pageSize);
    PygResult add(TbSpecificationOption tbSpecificationOption);

    TbSpecificationOption findOne(Long id);


    PygResult update(TbSpecificationOption tbSpecificationOption);

    PygResult delete(Long[] ids);

    PageResult<TbSpecificationOption> search(Integer page, Integer rows, String searchStr);

    List<TbSpecificationOption> findbyId(Long id);

//    List<Map> selectSpecificationOptionMapList();
}
