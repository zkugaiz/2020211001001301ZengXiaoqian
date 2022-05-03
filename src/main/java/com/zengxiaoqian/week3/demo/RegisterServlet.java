package com.zengxiaoqian.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
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
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
       /* PrintWriter writer = response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>email:"+email);
        writer.println("<br>birthdate"+birthdate);
        writer.close();*/
        PreparedStatement ps= null;
        ResultSet rs = null;
        String sql1 = " insert into usertable values (?,?,?,?,?,?) ";
        String sql2 = " select* from usertable ";
        PrintWriter writer = response.getWriter();
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,userid);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setString(6,birthdate);
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.executeQuery();
            rs=ps.executeQuery();
            writer.println("<table border=1> <tr> <th>userid</th> <th>username</th> <th>password</th> <th>email</th>" +
                    "<th>gender</th> <th>birthdate</th> </tr>" );
            while (rs.next()){
                writer.println("<tr> <th>"+rs.getString("userid")+"</th> ");
                writer.println(" <th>"+rs.getString("username")+"</th> ");
                writer.println(" <th>"+rs.getString("password")+"</th> ");
                writer.println(" <th>"+rs.getString("email")+"</th> ");
                writer.println(" <th>"+rs.getString("gender")+"</th> ");
                writer.println(" <th>"+rs.getString("birthdate")+"</th></tr>");
            }
            writer.println("</table>");
            response.sendRedirect("Login.jsp");
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
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
