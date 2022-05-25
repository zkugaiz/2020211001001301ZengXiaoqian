package com.zengxiaoqian.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/validation.jsp","/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()>");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()--request before chain");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session=req.getSession(false);
        if(session != null && session.getAttribute("login")!=null){
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else {
            res.sendRedirect("login.jsp");
            return;
        }
        chain.doFilter(request, response);
        System.out.println("i am in LoginFilter--doFilter()--response after chain");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()>");
    }

}
