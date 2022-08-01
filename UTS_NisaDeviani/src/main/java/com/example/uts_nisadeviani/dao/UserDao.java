package com.example.uts_nisadeviani.dao;

import com.example.uts_nisadeviani.model.User;
import com.example.uts_nisadeviani.utility.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DaoInterface<User> {

    @Override
    public ObservableList<User> getData() {
        ObservableList<User> ulist;
        ulist = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kueri = "SELECT * FROM user";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                String UserName = hasil.getString("UserName");
                String UserPassword = hasil.getString("UserPassword");
                User u = new User(UserName,UserPassword);
                ulist.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ulist;
    }

    @Override
    public void addData(User data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "INSERT INTO user VALUES(?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdUser());
            ps.setString(2, data.getUserName());
            ps.setString(3, data.getUserPassword());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("berhasil");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateData(User data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "UPDATE user SET UserName = ?, UserPassword = ? WHERE idUser = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdUser());
            ps.setString(2, data.getUserName());
            ps.setString(3, data.getUserPassword());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delData(User data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "DELETE FROM user WHERE idUser = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdUser());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
