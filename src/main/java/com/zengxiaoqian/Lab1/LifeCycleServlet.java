package com.zengxiaoqian.Lab1;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "LifeCycleServlet")
public class LifeCycleServlet extends javax.servlet.http.HttpServlet {
    public LifeCycleServlet(){
        System.out.println("I Am from default constructor --> LifeCycleServlet() ");
    }
    public void init(){
        System.out.println("init");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("service");
        ServletContext context = getServletContext();
        Integer count  = (Integer) context.getAttribute("count");
        if(count==null){
            count = new Integer(1);
        }else {
            count = new Integer(count.intValue()+1);
        }
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out= response.getWriter();
        out.print("<html><head><title>");
        out.print("counts and displays the number of times it has been accessed since the last server reboot");
        out.print("</title></head><body>");
        out.print(count +"visit");
        context.setAttribute("count",count);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }
    public void destroy() {
        System.out.println("destroy");
    }

}
