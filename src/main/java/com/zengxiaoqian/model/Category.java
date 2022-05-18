package com.zengxiaoqian.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryid;
    private  String categoryname;
    private  String description;
    private boolean active;

    public Category(){

    }

    public Category(int categoryid, String categoryname, String description, boolean active) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.description = description;
        this.active = active;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", categoryname='" + categoryname + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
    public  static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from category";
        List<Category> list = new ArrayList<Category>();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while(rs.next()){
            Category c=new Category();
            c.setCategoryid(rs.getInt("categoryid"));
            c.setCategoryname(rs.getString("categoryname"));
            c.setDescription(rs.getString("description"));
            list.add(c);
        }
        return list;
    }
    public static String findByCategory(Connection con,int categoryid)throws SQLException{
        String sql="select * from category where categoryid=?";
        List<Category> list = new ArrayList<Category>();
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryid);
        ResultSet rs = pt.executeQuery();
        String categoryname=null;
        while(rs.next()){
            Category c=new Category();
            categoryname=rs.getString("categoryname");
        }
        return categoryname;
    }
}
