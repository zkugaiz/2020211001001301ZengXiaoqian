package com.zengxiaoqian.dao;

import com.zengxiaoqian.model.Product;
import com.zengxiaoqian.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,price,CategoryID) values(?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductname());
        pt.setString(2, product.getProductdescription());
        /*if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }*/
        pt.setDouble(3, product.getPrice());
        pt.setInt(4, product.getCategoryid());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con)throws SQLException {

        return 0;

    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql="update product set productname=?,productdescription=?,picture=?,price=?,categoryid=? where productid=? ";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,instance.getProductname());
        ps.setString(2,instance.getProductdescription());
        if(instance.getPicture()!=null) {
            //for sql server
            ps.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        ps.setDouble(4, instance.getPrice());
        ps.setInt(5, instance.getCategoryid());
        ps.setInt(6,instance.getProductid());
        ps.executeUpdate();
        return 0;
    }

    @Override
    public Product findById(Integer productId,Connection con)throws SQLException{
        String queryString="select * from product where productid=?";
        PreparedStatement pt =con.prepareStatement(queryString);
        pt.setInt(1,productId);
        ResultSet rs =pt.executeQuery();
        Product product=new Product();
        while (rs.next()){
            product.setProductid(rs.getInt("productid"));
            product.setProductname(rs.getString("productname"));
            product.setProductdescription(rs.getString("productdescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryid(rs.getInt("categoryid"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> List=new ArrayList<Product>();
        try{
            String queryString = "select * from product";
            PreparedStatement pt = con.prepareStatement(queryString);
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Product product=new Product();
                product.setProductid(rs.getInt("productid"));
                product.setProductname(rs.getString("productname"));
                product.setProductdescription(rs.getString("productdescription"));
                product.setPrice(rs.getDouble("price"));
                product.setCategoryid(rs.getInt("categoryid"));
                List.add(product);
            }
            System.out.println("successful");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return List;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public byte[] getPictureById(Integer productId,Connection con)throws SQLException{
        byte[] imgByte=null;
        String sql="select picture from product where productid=?";
        PreparedStatement pt =con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgByte = blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }



}
