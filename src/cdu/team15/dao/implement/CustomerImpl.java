package cdu.team15.dao.implement;

import cdu.team15.dao.CustomerDao;
import cdu.team15.module.Customer;
import cdu.team15.util.SqlConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//该类继承了SqlConnectionUtil,会默认调用父类的无参构造方法,直接实现了数据库连接
public class CustomerImpl extends SqlConnectionUtil implements CustomerDao  {
//  操作数据库需要的字段
    PreparedStatement pstmt = null;

    @Override
//  实现添加顾客用户接口
    public int insert(Customer customer) {
        int rows = 0; //受影响行数
        String sql = "insert into customer_user (username,password) values(?,?)";
        try{
//          组装sql语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,customer.getUsername());
            pstmt.setString(2,customer.getPassword());
//          执行sql语句
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println("插入失败:"+customer+"\n"+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
//    实现按照用户名和密码查找用户的接口
    public Customer selectByNameAndPwd(String username, String password) {
//        声明Customer对象接收查询结果
        Customer customer = null;
        String sql = "select * from customer_user where username=? and password=?";
        try{
//          组装sql语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
//            执行sql查询语句
            ResultSet res =pstmt.executeQuery();
//          将结果集res的内容取出赋值给对象customer
            while(res.next()){
                customer = new Customer();
                customer.setCustomerID(res.getInt ("customerID"));
                customer.setUsername (res.getString("username"));
                customer.setPassword (res.getString("password"));
            }

        }catch (Exception e){
            System.out.println("查询失败："+sql);
            e.printStackTrace();
        }
        return customer;
    }
}
