package cdu.team15.filter;

import org.omg.CORBA.UserException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"},initParams = {@WebInitParam(name = "permitUrls",value = "/login.jsp,login")})
public class loginFilter implements Filter {
    String[] permitUrls = null;

    public void init(FilterConfig config) {
        permitUrls = config.getInitParameter("permitUrls").split(",");
    }



    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        System.out.println("访问的uri已经进入loginFilter");
        System.out.println("==============================================================================");
        System.out.println("loginfilter: requestURI=" +request.getRequestURI());
//        判断当前请求url是否不需要登录就可以访问
        boolean flag = false;
        for ( String uri : permitUrls){
            if (request.getRequestURI().endsWith(uri)){
                flag = true;
                System.out.println("访问的该uri末尾是"+uri);
            }
        }
//        接着只放行不需要用户登录就可以访问的uri和需要用户登录才能访问的uri且此时用户已经登陆。
        if (flag || request.getSession().getAttribute("username")!=null){
            chain.doFilter(req, resp);
        }else {
            System.out.println("不允许登录,返回登陆界面");
            System.out.println("==============================================================================");
            System.out.println("访问uri已经从loginFilter出来");
            request.getRequestDispatcher("login.jsp").forward(req,resp);
        }





    }

    public void destroy() {

    }


}
