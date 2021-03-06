package com.zengxiaoqian.dao;

import com.zengxiaoqian.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where userid=? ";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        ps.setString(5, String.valueOf(user.getBirthdate()));
        ps.setInt(6,user.getUserid());
        ps.executeUpdate();
        return 0;


    }


    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select userid,username,password,email,gender,birthdate from usertable where userid=?  ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();

        User user=null;
        if (rs.next()){
            user=new User();
            user.setUserid(rs.getInt("userid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail((rs.getString("email")));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql="select userid,username,password,email,gender,birthdate from usertable where username=? and password=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();

        User user=null;
        if (rs.next()){
            user=new User();
            user.setUserid(rs.getInt("userid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail((rs.getString("email")));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
