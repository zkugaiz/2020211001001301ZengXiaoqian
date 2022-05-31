package com.zengxiaoqian.Lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal){
        return firstVal+secondVal;
    }
    private int subtract(int firstVal,int secondVal){
        return firstVal-secondVal;
    }
    private int multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }
    private double divide(int firstVal,int secondVal){
        return firstVal/secondVal;
    }
    private int computerLength(String name){
        return name.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal=request.getParameter("firstVal")!=null?Integer.parseInt(request.getParameter("firstVal")):0;
        int secondVal=request.getParameter("secondVal")!=null?Integer.parseInt(request.getParameter("secondVal")):0;
        String name=request.getParameter("name");
        String action=request.getParameter("action");
        int result = 0;
        if (action.equals("add")){
            result=add(firstVal,secondVal);
        }else if(action.equals("subtract")){
            result=subtract(firstVal,secondVal);
        }else if(action.equals("multiply")){
            result=multiply(firstVal,secondVal);
        }else if (action.equals("divide")){
            result=(int)(divide(firstVal,secondVal));
        }else if (action.equals("computerLength")){
            result=computerLength(name);
        }
        if (action.equals("add")|| Objects.equals(action, "subtract") || Objects.equals(action, "multiply") || Objects.equals(action, "divide")) {
            Cookie cFirstVal=new Cookie("firstVal",String.valueOf(firstVal));
            Cookie cSecondVal=new Cookie("secondVal",String.valueOf(secondVal));
            Cookie cResult=new Cookie("result",String.valueOf(result));
            cFirstVal.setMaxAge(7);
            cSecondVal.setMaxAge(7);
            cResult.setMaxAge(7);
            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
        }
        if (Objects.equals(action, "computerLength")){
            Cookie cComputerLength=new Cookie("name",String.valueOf(name));
            Cookie cLength=new Cookie("length",String.valueOf(result));
            cComputerLength.setMaxAge(7);
            cLength.setMaxAge(7);
            response.addCookie(cComputerLength);
            response.addCookie(cLength);
        }
        response.sendRedirect("Lab3/cal.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
