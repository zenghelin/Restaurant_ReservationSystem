package cdu.team15.controller;

import cdu.team15.module.ReservationInfo;
import cdu.team15.service.Impl.ReservationServiceImpl;
import cdu.team15.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/doCheckReservationInfo")
public class doCheckReservationInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        接收获取到的参数
        String reservationID = request.getParameter("reservationID");
        String status = request.getParameter("status");
//        进行数据库数据更新，更新其预约信息状态
        ReservationService reservationService = new ReservationServiceImpl();
        int rows = reservationService.updateReservationStatus(new Integer(reservationID) ,status);
        PrintWriter out = response.getWriter();
        if (rows == 1){
               out.println("<script>alert('"+"审核信息成功"+"')</script>");
               out.println("<script>window.history.go(-2)</script>");
        }else {
            out.println("<script>alert('"+"审核信息失败"+"')</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
