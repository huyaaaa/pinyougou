package com.huyaaaaaa.manager.service;

import com.huyaaaaaa.pojo.TbTypeTemplate;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;

import java.util.List;

public interface TypeTemplateService {
    List<TbTypeTemplate> findAll();
    PageResult<TbTypeTemplate> findPage(Integer pageNum, Integer pageSize);
    PygResult add(TbTypeTemplate tbTypeTemplate);

    TbTypeTemplate findOne(Long id);


    PygResult update(TbTypeTemplate tbTypeTemplate);

    PygResult delete(Long[] ids);

    PageResult<TbTypeTemplate> search(Integer page, Integer rows, String searchStr);
}
