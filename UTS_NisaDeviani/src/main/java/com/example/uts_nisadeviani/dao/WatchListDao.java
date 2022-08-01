package com.example.uts_nisadeviani.dao;

import com.example.uts_nisadeviani.model.WatchList;
import com.example.uts_nisadeviani.utility.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchListDao implements DaoInterface<WatchList> {

    @Override
    public ObservableList<WatchList> getData() {
        ObservableList<WatchList> wlist;
        wlist = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kueri = "SELECT * FROM watchlist";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                Integer idWatchList = hasil.getInt("idWatchList");
                Integer LastWatch = hasil.getInt("LastWatch");
                Integer Favorite = hasil.getInt("Favorite");
                Integer Movie_idMovie = hasil.getInt("Movie_idMovie");
                Integer User_idUser = hasil.getInt("User_idUser");
                WatchList w = new WatchList(idWatchList,LastWatch,Favorite,Movie_idMovie,User_idUser);
                wlist.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wlist;
    }

    @Override
    public void addData(WatchList data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "INSERT INTO watchlist VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdWatchList());
            ps.setInt(2, data.getLastWatch());
            ps.setInt(3, data.getFavorite());
            ps.setInt(4, data.getMovie_idMovie());
            ps.setInt(5, data.getUser_idUser());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("berhasil");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateData(WatchList data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "UPDATE watchlist SET LastWatch = ?, Favorite = ?, Movie_idMovie = ?, User_idUser = ? WHERE idWatchList = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdWatchList());
            ps.setInt(2, data.getLastWatch());
            ps.setInt(3, data.getFavorite());
            ps.setInt(4, data.getMovie_idMovie());
            ps.setInt(5, data.getUser_idUser());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delData(WatchList data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "DELETE FROM watchlist WHERE idWatchList = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdWatchList());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
