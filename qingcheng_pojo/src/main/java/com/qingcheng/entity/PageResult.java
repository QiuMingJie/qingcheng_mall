package com.qingcheng.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-06 19:52
 * @Description
 */
public class PageResult<T> implements Serializable {

    private Long total;

    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
