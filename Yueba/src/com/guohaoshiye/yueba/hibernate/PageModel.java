package com.guohaoshiye.yueba.hibernate;
/*
* 设置分页查询
* */
import java.util.List;

public class PageModel<T>
{
  private int currentPage = 1;

  private int pageSize = 5;

  private int sumCount;

  private int sumPage;
  private List<T> list;

  public int getCurrentPage()
  {
    return this.currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
    if (currentPage > this.sumPage) {
      this.currentPage = this.sumPage;
    } else if (currentPage < 1) {
      this.currentPage = 1;
    }
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getSumCount() {
    return this.sumCount;
  }

  public void setSumCount(int sumCount) {
    this.sumCount = sumCount;
    this.sumPage = ((int)Math.ceil(sumCount / this.pageSize));
    if (this.sumPage == 0)
      this.sumPage = 1;
  }

  public int getSumPage() {
    return this.sumPage;
  }

  public List<T> getList() {
    return this.list;
  }

  public void setList(List list) {
    this.list = list;
  }
}

