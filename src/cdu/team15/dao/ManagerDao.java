package cdu.team15.dao;

import cdu.team15.module.Manager;
//经理用户的接口
public interface ManagerDao {
    //增加经理用户
//    int insert(Manager manager);
    //修改经理用户
//    int update(Manager manager);
    //删除经理用户
//    int delete(int managerID);
    //按密码和名字查询经理用户
    Manager selectByNameAndPwd(String username, String password);



}
