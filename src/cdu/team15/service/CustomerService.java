package cdu.team15.service;

public interface CustomerService  {
//    检查登录用户名密码是否正确
    boolean loginCheck(String username, String password);
//    通过顾客用户名密码获取ID
    int getCustomerIDByUserAndPwd(String username,String password);

}
