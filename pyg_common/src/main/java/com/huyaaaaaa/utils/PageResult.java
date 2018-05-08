package com.huyaaaaaa.utils;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    Long total;
    List<?> rows;

    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
