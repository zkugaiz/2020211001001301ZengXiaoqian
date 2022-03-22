package com.zengxiaoqian.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet",urlPatterns = {"/config"},initParams = {
        @WebInitParam(name = "name",value = "zengxiaoqian"),@WebInitParam(name = "studentid",value = "2020211001001301")
}
)
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig Config = getServletConfig();
        String name = Config.getInitParameter("name");
        String studentid = Config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);

    }
}
