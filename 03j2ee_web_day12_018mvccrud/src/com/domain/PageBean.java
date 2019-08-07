package com.domain;

import java.util.List;
import java.util.Map;

/*
需要做的功能
1. 分页
2. 组合查询
3. 分页查询
4. 查询条件回显
 */

public class PageBean<T> {
    public static Integer recordPerPage=3;
    private Integer recordTotal;
    private Integer pageTotal;
    Map<String, String> filterList;
    List<T>  list;
    private Integer current=1;

    public PageBean(Integer recordPerPage, Integer recordTotal, Integer pageTotal, Map<String, String> filterList, List<T> list, Integer current) {
        this.recordPerPage = recordPerPage;
        this.recordTotal = recordTotal;
        this.pageTotal = pageTotal;
        this.filterList = filterList;
        this.list = list;
        this.current = current;
    }

    public PageBean() {
    }

    public Integer getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal) {
        this.recordTotal = recordTotal;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Map<String, String> getFilterList() {
        return filterList;
    }

    public void setFilterList(Map<String, String> filterList) {
        this.filterList = filterList;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(Integer recordPerPage) {
        this.recordPerPage = recordPerPage;
    }
}
