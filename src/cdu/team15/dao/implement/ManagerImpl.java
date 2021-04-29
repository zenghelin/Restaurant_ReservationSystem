package cdu.team15.dao.implement;

import cdu.team15.dao.ManagerDao;
import cdu.team15.module.Manager;
import cdu.team15.util.SqlConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//该类继承了SqlConnectionUtil,会默认调用父类的无参构造方法,直接实现了数据库连接
public class ManagerImpl extends SqlConnectionUtil implements ManagerDao {
    //  操作数据库需要的字段
    PreparedStatement pstmt = null;
    @Override
    public Manager selectByNameAndPwd(String username, String password) {
//        声明Manager对象存储查找结果
        Manager manager = null;
//        声明sql语句
        String sql = "select * from manager_user where username=? and password=?";
//        组装sql语句
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
//          执行sql查询语句
            ResultSet res = pstmt.executeQuery();
//          结果集提取出数据
            while (res.next()){
                manager = new Manager();
                manager.setManagerID(res.getInt("managerID"));
                manager.setUsername(res.getString("username"));
                manager.setPassword(res.getString("password"));
            }

        } catch (Exception e) {
            System.out.println("查找失败:"+sql);
            e.printStackTrace();
        }
//        返回查询信息
        return manager;
    }
}
