package com.ilovemengmei.ccstraining2020.dao.impl;

import com.ilovemengmei.ccstraining2020.dao.UserDao;
import com.ilovemengmei.ccstraining2020.domain.User;
import com.ilovemengmei.ccstraining2020.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner qr = new QueryRunner(JDBCUtil.getInstance().getDataSource());

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username='" + username + "'";
        try {
            return qr.query(sql, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM user WHERE id=" + id;
        try {
            return qr.query(sql, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int insert(User user) {
        String sql = "INSERT INTO user(username, password,email,profilePhoto,balance) values(?,?,?,?,?)";
        try {
            return qr.update(sql, user.getUsername(), user.getPassword(),user.getEmail(),user.getProfilePhoto(),user.getBalance());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE user SET username=?, password=?,email=?,profilePhoto=?,balance=? WHERE id=?";
        try {
            return qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getProfilePhoto(),user.getBalance(),user.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException();
    }

}
