package cdu.team15.service;

import cdu.team15.dao.ManagerDao;
import cdu.team15.dao.implement.ManagerImpl;
import cdu.team15.module.Manager;


public class testManagerDaoService {
//    测试selectByNameAndPwd(方法）
    public static void main(String[] args) {
        new testManagerDaoService().manager_selectByNameAndPwd_Check("m111","m222");
    }

    ManagerDao managerDao = new ManagerImpl();
    public boolean  manager_selectByNameAndPwd_Check(String username, String password){
        Manager manager = managerDao.selectByNameAndPwd(username,password);
        System.out.println(manager);
        return  manager !=null;
    }
}
