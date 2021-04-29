package cdu.team15.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet("/loginOutServlet")
public class loginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//       设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        检查会话的内容
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if (session.getAttribute("username")!=null){
//        提示用户已注销登陆
            System.out.println("<script>alert(已注销，点击返回登录页面)</script>");
            response.sendRedirect("login.jsp");

        }


    }
}
