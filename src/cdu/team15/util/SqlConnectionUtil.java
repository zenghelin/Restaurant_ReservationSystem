package cdu.team15.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//数据库连接的工具类，提供conn直接供数据库交互使用
public class SqlConnectionUtil {
    //为数据库连接准备数据
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url2 ="jdbc:mysql://localhost:3306/restaurant_reservation_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=root&password=123456";
    //封装数据，只能能被子类访问
    protected Connection conn=null;
    public SqlConnectionUtil(){
        connect();//连接数据库
    }
    protected  void connect(){
        try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url2);
        } catch (Exception e) {
            System.out.println("数据库连接失败："+e.getMessage());
        }
    }
    protected void  close(){
        try {
            //在数据库已连接且未关闭的情况下
            if (conn!=null&&!conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            System.out.println("关闭失败"+e.getMessage());
        }
    }

}
