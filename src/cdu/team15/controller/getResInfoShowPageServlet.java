package cdu.team15.controller;

import cdu.team15.module.ReservationInfo;
import cdu.team15.service.Impl.ReservationServiceImpl;
import cdu.team15.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;
//获取预约信息展示页面
@WebServlet("/getResInfoShowPage")
public class getResInfoShowPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ReservationService reservationService =new ReservationServiceImpl();
//        按预约信息状态查询预约信息
        List<ReservationInfo> reservationInfoWaits = reservationService.findReservationInfosByStatus("待审核");
        List<ReservationInfo> reservationInfoOks = reservationService.findReservationInfosByStatus("预约成功");
        List<ReservationInfo> reservationInfoNos = reservationService.findReservationInfosByStatus("预约失败");
//        将预约信息返回给页面
        request.setAttribute("reservationInfoWaits",reservationInfoWaits);
        request.setAttribute("reservationInfoOks",reservationInfoOks);
        request.setAttribute("reservationInfoNos",reservationInfoNos);
//        将页面返回给前端
        request.getRequestDispatcher("reservationInfoShow.jsp").forward(request,response);

    }
}
