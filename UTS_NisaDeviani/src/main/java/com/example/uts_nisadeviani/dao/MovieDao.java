package com.example.uts_nisadeviani.dao;

import com.example.uts_nisadeviani.model.Movie;
import com.example.uts_nisadeviani.utility.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao implements DaoInterface<Movie> {
    @Override
    public ObservableList<Movie> getData() {
        ObservableList<Movie> mlist;
        mlist = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kueri = "SELECT * FROM movie";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                Integer idMovie = hasil.getInt("idMovie");
                String Title = hasil.getString("Title");
                String Genre = hasil.getString("Genre");
                Integer Durasi = hasil.getInt("Durasi");
                Movie m = new Movie(idMovie,Title,Genre,Durasi);
                mlist.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mlist;
    }

    @Override
    public void addData(Movie data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "INSERT INTO movie VALUES(?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdMovie());
            ps.setString(2, data.getTitle());
            ps.setString(3, data.getGenre());
            ps.setInt(4, data.getDurasi());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("berhasil");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateData(Movie data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "UPDATE movie SET Title = ?, Genre = ?, Durasi = ? WHERE idMovie = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdMovie());
            ps.setString(2, data.getTitle());
            ps.setString(3, data.getGenre());
            ps.setInt(4, data.getDurasi());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delData(Movie data) {
        Connection conn = MyConnection.getConnection();
        String kueri = "DELETE FROM movie WHERE idMovie = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kueri);
            ps.setInt(1, data.getIdMovie());
            int hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
