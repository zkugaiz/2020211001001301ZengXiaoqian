package com.zengxiaoqian.week5.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet" , value="/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        super.init();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;database=userdb;enrypt=false";
        String username = "la";
        String password = "123456789";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection -->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PreparedStatement ps= null;
        ResultSet rs = null;
        PrintWriter writer = response.getWriter();

        String sql1 ="select*  from usertable where username= ? and password =? ";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeQuery();
            rs=ps.executeQuery();
            if(rs.next()){
                writer.println("<h1>Login Success </h1> ");
                writer.println(" <h1>Welcome,"+rs.getString("username")+"</h1>");
            }else{
                writer.println("<h1>Username or Password Error</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
