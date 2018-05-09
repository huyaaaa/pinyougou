package com.huyaaaaaa.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huyaaaaaa.manager.service.SpecificationOptionService;
import com.huyaaaaaa.manager.service.SpecificationService;
import com.huyaaaaaa.pojo.TbSpecification;
import com.huyaaaaaa.utils.MessageChnResolver;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import com.huyaaaaaa.vo.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("specification")
public class SpecificationController {
    @Reference
    SpecificationService specificationService;
    @Reference
    SpecificationOptionService specificationOptionService;


    @RequestMapping("findAll")
    public List<TbSpecification> findAll(){
        List<TbSpecification> list = specificationService.findAll();
        return list;
    }
    //可以被search代替，已经不使用了
    @RequestMapping("findPage")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows){
        PageResult<TbSpecification> page1 = specificationService.findPage(page, rows);
        return page1;
    }
    @RequestMapping("add")
    public PygResult add(@RequestBody Specification specification){
       PygResult pygResult;
        pygResult=specificationService.add(specification);
        return pygResult;
    }

    @RequestMapping("findOne")
    public Specification findOne(Long id){
        Specification specification = new Specification();
        specification.setTbSpecification(specificationService.findOne(id));
        specification.setList(specificationOptionService.findbyId(id));
        return specification;
    }
    @RequestMapping("update")
    public PygResult update(@RequestBody  Specification specification){
        PygResult result = specificationService.update(specification);
        return result;
    }
    @RequestMapping("delete")
    public PygResult delete(Long[] ids){
        PygResult pygResult=specificationService.delete(ids);
        return pygResult;
    }
    @RequestMapping("search")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows,
                               @RequestBody MessageChnResolver mcr){
        System.out.println(mcr.getMessage());
        PageResult<TbSpecification> page1 = specificationService.search(page, rows,mcr.getMessage());
        System.out.println(page1.getRows().get(0));
        return page1;
    }
    @RequestMapping("selectSpecMapList")
    public List<Map> selectSpecMapList(){
        List<Map> mapList = specificationService.selectSpecMapList();
        return mapList;
    }
}
