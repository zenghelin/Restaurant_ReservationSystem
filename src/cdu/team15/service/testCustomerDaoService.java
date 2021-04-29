package cdu.team15.service;
import cdu.team15.dao.CustomerDao;
import cdu.team15.dao.implement.CustomerImpl;
import cdu.team15.module.Customer;

public class testCustomerDaoService {

//    声明main函数测试Dao层方法
    public static void main(String[] args) {
//        一、测试CustomerDao接口的
//        1.测试insert方法（通过）
        Customer  customer = new Customer();
        customer.setUsername("xAAA");
        customer.setPassword("xBBB");
        new testCustomerDaoService().cus_insert_Check(customer);
//        2.测试selectByNameAndPwd方法（通过）
        new testCustomerDaoService().cus_selectByNameAndPwd_Check("111","222");


    }
//     一、测试CustomerDao接口的方法
//    动态绑定，用实现类CustomerImpl声明一个抽象类CustomerDao ，让其调用其方法
    CustomerDao customerDao = new CustomerImpl();

    //    1.测试insert方法（通过）
    public int cus_insert_Check(Customer customer){
       return customerDao.insert(customer);
    }

//    2.测试selectByNameAndPwd方法（通过）
    public boolean cus_selectByNameAndPwd_Check(String username, String password){
        Customer customer = customerDao.selectByNameAndPwd(username, password);
        System.out.println(customer);
//        若数据不为空返回true,若有返回false
        return customer != null;
    }


}
