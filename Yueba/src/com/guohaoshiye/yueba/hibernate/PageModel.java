/*    */ package com.guohaoshiye.yueba.hibernate;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class PageModel<T>
/*    */ {
/*  7 */   private int currentPage = 1;
/*    */   
/*  9 */   private int pageSize = 5;
/*    */   
/*    */   private int sumCount;
/*    */   
/*    */   private int sumPage;
/*    */   private List<T> list;
/*    */   
/*    */   public int getCurrentPage()
/*    */   {
/* 18 */     return this.currentPage;
/*    */   }
/*    */   
/*    */   public void setCurrentPage(int currentPage) {
/* 22 */     this.currentPage = currentPage;
/* 23 */     if (currentPage > this.sumPage) {
/* 24 */       this.currentPage = this.sumPage;
/* 25 */     } else if (currentPage < 1) {
/* 26 */       this.currentPage = 1;
/*    */     }
/*    */   }
/*    */   
/*    */   public int getPageSize() {
/* 31 */     return this.pageSize;
/*    */   }
/*    */   
/*    */   public void setPageSize(int pageSize) {
/* 35 */     this.pageSize = pageSize;
/*    */   }
/*    */   
/*    */   public int getSumCount() {
/* 39 */     return this.sumCount;
/*    */   }
/*    */   
/*    */   public void setSumCount(int sumCount) {
/* 43 */     this.sumCount = sumCount;
/* 44 */     this.sumPage = ((int)Math.ceil(sumCount / this.pageSize));
/* 45 */     if (this.sumPage == 0)
/* 46 */       this.sumPage = 1;
/*    */   }
/*    */   
/*    */   public int getSumPage() {
/* 50 */     return this.sumPage;
/*    */   }
/*    */   
/*    */   public List<T> getList() {
/* 54 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List list) {
/* 58 */     this.list = list;
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\hibernate\PageModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */