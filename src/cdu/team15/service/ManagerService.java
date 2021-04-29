package cdu.team15.service;

import cdu.team15.module.Manager;

public interface ManagerService {
    //按密码和名字查询经理用户
    boolean loginCheck(String username, String password);
//    通过用户名密码获取ID
    int getManagerIDByUserAndPwd(String username,String password);
}
