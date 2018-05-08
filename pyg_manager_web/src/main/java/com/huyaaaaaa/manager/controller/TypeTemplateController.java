package com.huyaaaaaa.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huyaaaaaa.manager.service.TypeTemplateService;
import com.huyaaaaaa.pojo.TbTypeTemplate;
import com.huyaaaaaa.utils.MessageChnResolver;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("typeTemplate")
public class TypeTemplateController {
    @Reference
    TypeTemplateService typetemplateService;

    @RequestMapping("findAll")
    public List<TbTypeTemplate> findAll(){
        List<TbTypeTemplate> list = typetemplateService.findAll();
        return list;
    }
    //可以被search代替，已经不使用了
    @RequestMapping("findPage")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows){
        PageResult<TbTypeTemplate> page1 = typetemplateService.findPage(page, rows);
        return page1;
    }
    @RequestMapping("add")
    public PygResult add(@RequestBody TbTypeTemplate tbtypetemplate){
       PygResult pygResult;
        pygResult=typetemplateService.add(tbtypetemplate);
        return pygResult;
    }

    @RequestMapping("findOne")
    public TbTypeTemplate findOne(Long id){
        TbTypeTemplate one = typetemplateService.findOne(id);
        return one;
    }
    @RequestMapping("update")
    public PygResult update(@RequestBody  TbTypeTemplate tbtypetemplate){
        PygResult result = typetemplateService.update(tbtypetemplate);
        return result;
    }
    @RequestMapping("delete")
    public PygResult delete(Long[] ids){
        PygResult pygResult=typetemplateService.delete(ids);
        return pygResult;
    }
    @RequestMapping("search")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows,
                               @RequestBody MessageChnResolver mcr){
       // System.out.println(mcr.getMessage());
        PageResult<TbTypeTemplate> page1 = typetemplateService.search(page, rows,mcr.getMessage());
        return page1;
    }

}
