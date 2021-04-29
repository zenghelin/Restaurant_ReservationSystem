package cdu.team15.controller;

import cdu.team15.module.ReservationInfo;
import cdu.team15.service.Impl.ReservationServiceImpl;
import cdu.team15.service.ReservationService;

import java.io.PrintWriter;

//处理新添加的预约信息
@javax.servlet.annotation.WebServlet("/doAddReservationInfo")
public class doAddReservationInfoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//       设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        接收参数
        String customerID = request.getParameter("userID");
        String telName = request.getParameter("telName");
        String telNumber = request.getParameter("telNumber");
        String reachTime = request.getParameter("reachTime");
        String nums = request.getParameter("nums");
        String otherNeed = request.getParameter("otherNeed");
        System.out.println("接收到的参数："+customerID+telName+telNumber+reachTime+nums+otherNeed);
//        添加预约信息到数据库
        ReservationService reservationService = new ReservationServiceImpl();

        ReservationInfo reservationInfo = new ReservationInfo();
        reservationInfo.setCustomerID(new Integer(customerID));
        reservationInfo.setTelName(telName);
        reservationInfo.setTelNumber(telNumber);
        reservationInfo.setReachTime(reachTime);
        reservationInfo.setNums(new Integer(nums));
        reservationInfo.setOtherNeed(otherNeed);

        System.out.println(reservationInfo);

        PrintWriter out = response.getWriter();

//        执行添加预约信息函数
        int rows = reservationService.addReservationInfo(reservationInfo);
        if (rows == 1){
            response.sendRedirect("addNewResSuccess.html");


        }else {
            out.println("<script> alert('"+"提交预约信息失败"+"')</script>");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request,response);
    }
}
