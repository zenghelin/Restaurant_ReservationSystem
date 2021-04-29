package cdu.team15.service.Impl;

import cdu.team15.dao.ManagerDao;
import cdu.team15.dao.implement.ManagerImpl;
import cdu.team15.module.Manager;
import cdu.team15.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao = new ManagerImpl();
//经理登陆检查用户密码是否正确
    @Override
    public boolean loginCheck(String username, String password){
        Manager manager = managerDao.selectByNameAndPwd(username,password);
        System.out.println(manager);
        return  manager !=null;

    }
//    通过顾客用户名密码获取ID
    @Override
    public int getManagerIDByUserAndPwd(String username, String password) {
        Manager manager = managerDao.selectByNameAndPwd(username,password);
        int managerID = manager.getManagerID();
        System.out.println("查询到的经理ID为："+managerID);
        return managerID;
    }
}
