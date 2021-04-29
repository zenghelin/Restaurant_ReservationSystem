package cdu.team15.controller;

import cdu.team15.module.ReservationInfo;
import cdu.team15.service.CustomerService;
import cdu.team15.service.Impl.CustomerServiceImpl;
import cdu.team15.service.Impl.ManagerServiceImpl;
import cdu.team15.service.Impl.ReservationServiceImpl;
import cdu.team15.service.ManagerService;
import cdu.team15.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//处理从登录界面提交的Post登录请求
@WebServlet("/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        接收登陆界面传过来的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println("请求参数："+username+password+role);
//        判断是否允许登陆
        boolean isAllowLogin = false;
//        判断登录表单输入域
        if (username==null||password==null||username.equals("")){
            response.sendRedirect("user/login.jsp");
            return;
        }

//        声明一个临时会话session，存储登录的用户信息
        HttpSession session = request.getSession();

        if (role.equals("顾客")){
//            声明service层类对象调用service层方法
            CustomerService customerService = new CustomerServiceImpl();
//            进行用户密码匹配检查
            isAllowLogin = customerService.loginCheck(username,password);


        }else if (role.equals("经理")){
            ManagerService managerService = new ManagerServiceImpl();
            isAllowLogin = managerService.loginCheck(username,password);
        }
        else {
            System.out.println("非法用户");
            return;
        }

        PrintWriter out = response.getWriter();
        int userID = 0;//声明一个用户id,不确定角色 所以用userID来代替
        List<ReservationInfo> reservationInfos = null;//声明一个变量接收预约信息
        ReservationService reservationService = new ReservationServiceImpl();


//        如果用户密码匹配且角色为“顾客”，则跳转到填写预约界面
        if (isAllowLogin && role.equals("顾客")){

//       将用户名密码和角色存放到缓存中，以便于判断是否登录，后面过滤要用到，当注销的时候就清除缓存即可完成。
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("role",role);

//            声明service层类CustomerService对象调用service层方法
            CustomerService customerService = new CustomerServiceImpl();
//            根据用户名密码查找用户的ID
            userID = customerService.getCustomerIDByUserAndPwd(username,password);

//            向前端返回数据到页面
            request.setAttribute("userID",userID);
//            返回给用户页面所有提交成功的预约信息列表
            reservationInfos = reservationService.newAddReservationOne(new Integer(userID));
            request.setAttribute("reservationInfos",reservationInfos);
//            向前端返回页面
            request.getRequestDispatcher("addReservationInfo.jsp").forward(request,response);



//            如果用户名匹配且角色为“经理”，则跳转审核预约信息界面
        }else if (isAllowLogin && role.equals("经理")){

//       将用户名密码和角色存放到缓存中，以便于判断是否登录，后面过滤要用到，当注销的时候就清除缓存即可完成。
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("role",role);

//            ManagerService managerService = new ManagerServiceImpl();
//            userID = managerService.getManagerIDByUserAndPwd(username,password);
//            request.setAttribute("userID",userID);


//            讲请求转发给getResInfoShowPageServlet进行处理
            request.getRequestDispatcher("getResInfoShowPage").forward(request,response);


        } else {
            out.println("<h1>"+role+"为非法用户"+username+"登陆失败</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
