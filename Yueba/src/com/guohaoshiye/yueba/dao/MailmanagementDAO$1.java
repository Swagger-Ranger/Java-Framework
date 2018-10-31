/*
package com.guohaoshiye.yueba.dao;

import com.guohaoshiye.yueba.entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.jdbc.Work;












class MailmanagementDAO$1
  implements Work
{
  MailmanagementDAO$1(MailmanagementDAO this$0, List paramList, String paramString, Timestamp paramTimestamp) {}

  int count = 0;

  public void execute(Connection conn) throws SQLException {
    String sql = "INSERT INTO mailmanagement (uid,content,state,type,goods,createtime) VALUES (?,?,?,?,?,?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    for (Users users : this.val$list) {
      ps.setInt(1, users.getId().intValue());
      ps.setString(2, this.val$describe);
      ps.setInt(3, 0);
      ps.setInt(4, 0);
      ps.setString(5, "");
      ps.setTimestamp(6, this.val$d);
      ps.addBatch();
      if (++this.count % 1000 == 0) {
        ps.executeBatch();
      }
    }
    ps.executeBatch();
  }
}

*/
