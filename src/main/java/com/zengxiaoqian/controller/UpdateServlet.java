package com.zengxiaoqian.controller;

import com.zengxiaoqian.dao.UserDao;
import com.zengxiaoqian.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException{
        super.init();
     /*   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;database=userdb;enrypt=false";
        String username = "la";
        String password = "123456789";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection -->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid= request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUserid(Integer.parseInt(userid));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthdate(Date.valueOf(birthdate));
        UserDao userDao=new UserDao();
        try {
            int u = userDao.updateUser(con,user);
            if(u==0){
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);;
            }else{
                request.setAttribute("message","Update Error!!!");
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }
}
