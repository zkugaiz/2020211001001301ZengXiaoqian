package com.zengxiaoqian.controller;

import com.zengxiaoqian.dao.ProductDao;
import com.zengxiaoqian.model.Category;
import com.zengxiaoqian.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public  void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int categoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String productDescription = request.getParameter("productDescription");
        InputStream inputStream = null;
        Part fileParts =(Part) request.getPart("picture");
        if(fileParts!=null){
            inputStream=fileParts.getInputStream();
        }
        Product product=new Product();
        product.setProductname(productName);
        product.setProductdescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryid(categoryId);

        ProductDao productDao=new ProductDao();
        try {
            int n=productDao.save(product,con);
            if(1>0)
                response.sendRedirect("productList");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


        List<Category> categoryList= Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        String path ="WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request,response);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
