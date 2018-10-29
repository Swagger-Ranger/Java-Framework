/*    */ package com.aiwan.dao;
/*    */ 
/*    */ import com.aiwan.entity.Users;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.List;
/*    */ import org.hibernate.jdbc.Work;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MailmanagementDAO$1
/*    */   implements Work
/*    */ {
/*    */   MailmanagementDAO$1(MailmanagementDAO this$0, List paramList, String paramString, Timestamp paramTimestamp) {}
/*    */   
/* 27 */   int count = 0;
/*    */   
/*    */   public void execute(Connection conn) throws SQLException {
/* 30 */     String sql = "INSERT INTO mailmanagement (uid,content,state,type,goods,createtime) VALUES (?,?,?,?,?,?)";
/* 31 */     PreparedStatement ps = conn.prepareStatement(sql);
/* 32 */     for (Users users : this.val$list) {
/* 33 */       ps.setInt(1, users.getId().intValue());
/* 34 */       ps.setString(2, this.val$describe);
/* 35 */       ps.setInt(3, 0);
/* 36 */       ps.setInt(4, 0);
/* 37 */       ps.setString(5, "");
/* 38 */       ps.setTimestamp(6, this.val$d);
/* 39 */       ps.addBatch();
/* 40 */       if (++this.count % 1000 == 0) {
/* 41 */         ps.executeBatch();
/*    */       }
/*    */     }
/* 44 */     ps.executeBatch();
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\dao\MailmanagementDAO$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */