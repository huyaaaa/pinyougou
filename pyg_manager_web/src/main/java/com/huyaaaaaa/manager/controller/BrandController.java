package com.huyaaaaaa.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huyaaaaaa.manager.service.BrandService;
import com.huyaaaaaa.pojo.TbBrand;
import com.huyaaaaaa.utils.MessageChnResolver;
import com.huyaaaaaa.utils.PageResult;
import com.huyaaaaaa.utils.PygResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    BrandService brandService;

    @RequestMapping("findAll")
    public List<TbBrand> findAll(){
        List<TbBrand> list = brandService.findAll();
        return list;
    }
    //可以被search代替，已经不使用了
    @RequestMapping("findPage")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows){
        PageResult<TbBrand> page1 = brandService.findPage(page, rows);
        return page1;
    }
    @RequestMapping("add")
    public PygResult add(@RequestBody TbBrand tbBrand){
       PygResult pygResult;
        pygResult=brandService.add(tbBrand);
        return pygResult;
    }

    @RequestMapping("findOne")
    public TbBrand findOne(Long id){
        TbBrand one = brandService.findOne(id);
        return one;
    }
    @RequestMapping("update")
    public PygResult update(@RequestBody  TbBrand tbBrand){
        PygResult result = brandService.update(tbBrand);
        return result;
    }
    @RequestMapping("delete")
    public PygResult delete(Long[] ids){
        PygResult pygResult=brandService.delete(ids);
        return pygResult;
    }
    @RequestMapping("search")
    public PageResult findPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer rows,
                               @RequestBody MessageChnResolver mcr){
       // System.out.println(mcr.getMessage());
        PageResult<TbBrand> page1 = brandService.search(page, rows,mcr==null?"":mcr.getMessage());
        return page1;
    }
    @RequestMapping("selectBrandList")
    public List selectBrandList(){
        List<Map> list = brandService.selectBrandMapList();
        return list;
    }

}
