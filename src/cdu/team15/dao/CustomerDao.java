package cdu.team15.dao;

import cdu.team15.module.Customer;

public interface CustomerDao {
    //接口的方法默认是抽象的
    //增加顾客用户
    int insert(Customer customer);
    //修改顾客用户
//    int update(Customer customer);
    //删除顾客用户
//    int delete(int customerID);
    //通过用户名密码查询顾客用户
    Customer selectByNameAndPwd(String username,String password);


}
