package com.huyaaaaaa.vo;

import com.huyaaaaaa.pojo.TbSpecification;
import com.huyaaaaaa.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

public class Specification implements Serializable {
    private TbSpecification tbSpecification;
    private List<TbSpecificationOption> list;

    public Specification() {
    }

    public Specification(TbSpecification tbSpecification, List<TbSpecificationOption> list) {
        this.tbSpecification = tbSpecification;
        this.list = list;
    }

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getList() {
        return list;
    }

    public void setList(List<TbSpecificationOption> list) {
        this.list = list;
    }
}
