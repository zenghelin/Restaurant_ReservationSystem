package cdu.team15.service.Impl;

import cdu.team15.dao.CustomerDao;
import cdu.team15.dao.implement.CustomerImpl;
import cdu.team15.module.Customer;
import cdu.team15.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerImpl();
    //    检查登录用户名密码是否正确
    @Override
    public boolean loginCheck(String username, String password){
        Customer customer = customerDao.selectByNameAndPwd(username, password);
        System.out.println(customer);
//        若数据不为空返回true,若有返回false
        return customer != null;
    }

    @Override
    public int getCustomerIDByUserAndPwd(String username, String password) {
       Customer customer = customerDao.selectByNameAndPwd(username,password);
       int customerID = customer.getCustomerID();
       System.out.println("查询到的顾客ID为："+customerID);
       return customerID;
    }

}
