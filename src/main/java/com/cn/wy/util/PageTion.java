package com.cn.wy.util;

import java.util.List;

public class PageTion<T> {
    //当前页
    private int pageNumber;
    //每页显示多少
    private int pageSize;
    private List<?> content;
    //总页数
    private int totalPages;
    //总条数
    private int totalElements;


    public PageTion() {

    }


    public PageTion(int pageNumber, int pageSize, List<?> content, int totalElements) {
        super();
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
        if (pageSize != 0)
            this.totalPages = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
    }

}
