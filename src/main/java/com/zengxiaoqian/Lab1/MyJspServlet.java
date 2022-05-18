package com.zengxiaoqian.Lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyJspServlet")
public class MyJspServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String  Class=request.getParameter("class");
        String id=request.getParameter("id");
        PrintWriter writer=response.getWriter();
        writer.println("<br>name:"+name);
        writer.println("<br>class:"+Class);
        writer.println("<br>id:"+id);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
