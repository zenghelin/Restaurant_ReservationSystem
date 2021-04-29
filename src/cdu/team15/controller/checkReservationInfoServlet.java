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

@WebServlet("/checkReservationInfo")
public class checkReservationInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        接收参数，转换为Int型
        int reservationID = new Integer(request.getParameter("reservationID")) ;
//        从数据库查询该条数据，确保数据库有此信息，并且审核状态还是待审核,防止页面未更新造成无用修改。
        ReservationService reservationService = new ReservationServiceImpl();
        ReservationInfo reservationInfo = reservationService.isHaveReservationInfo(reservationID);

        System.out.println(reservationInfo);
        PrintWriter out = response.getWriter();
//        将待修改的预约信息传给预约信息审核页面
        if(reservationInfo!= null && reservationInfo.getStatus().equals("待审核")){
//            返回数据给页面
            request.setAttribute("reservationID",reservationInfo.getReservationID());
            request.setAttribute("reservationInfo",reservationInfo);
//            返回页面给前端
            request.getRequestDispatcher("reservationInfoCheck.jsp").forward(request,response);
        }else {
            out.println("<script>alert('"+"该预约信息不存在或者已经被审核，请刷新后重试"+"')</script>");
            out.println("<script>window.history.go(-1)</script>");
        }

    }
}
