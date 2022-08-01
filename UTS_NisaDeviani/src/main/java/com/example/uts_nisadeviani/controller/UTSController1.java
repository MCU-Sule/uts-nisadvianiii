package com.example.uts_nisadeviani.controller;

import com.example.uts_nisadeviani.HelloApplication;
import com.example.uts_nisadeviani.dao.MovieDao;
import com.example.uts_nisadeviani.dao.UserDao;
import com.example.uts_nisadeviani.dao.WatchListDao;
import com.example.uts_nisadeviani.model.Movie;
import com.example.uts_nisadeviani.model.User;
import com.example.uts_nisadeviani.model.WatchList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class UTSController1 {
    public ComboBox<Movie> cmbGenre;
    public ListView<User> lvUser;
    public TableView<Movie> table1;
    public TableColumn<Movie, String> kolom1;
    public TableColumn<Movie, String> kolom2;
    public TableColumn<Movie, Integer> kolom3;
    public TableView<WatchList> table2;
    public TableColumn<WatchList, Integer> kolomA;
    public TableColumn<WatchList, Integer> kolomB;
    public TableColumn<WatchList, Integer> kolomC;

    private Stage stage;
    private ObservableList<Movie> mlist;
    private ObservableList<User> ulist;
    private ObservableList<WatchList> wlist;


    private UserDao userDao;
    private MovieDao movieDao;
    private WatchListDao watchListDao;

    public void initialize() {
        stage = new Stage();
        movieDao = new MovieDao();
        userDao = new UserDao();
        watchListDao = new WatchListDao();

        mlist = movieDao.getData();
        ulist = userDao.getData();
        wlist = watchListDao.getData();

        table1.setItems(mlist);
        kolom1.setCellValueFactory(new PropertyValueFactory<Movie, String>("Title"));
        kolom2.setCellValueFactory(new PropertyValueFactory<Movie, String>("Genre"));
        kolom3.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("Durasi"));

        table2.setItems(wlist);
        kolomA.setCellValueFactory(new PropertyValueFactory<WatchList, Integer>("Movie_idMovie"));
        kolomB.setCellValueFactory(new PropertyValueFactory<WatchList, Integer>("LastWatch"));
        kolomC.setCellValueFactory(new PropertyValueFactory<WatchList, Integer>("Favorite"));

        ulist.setAll(ulist);
        cmbGenre.setItems(mlist);
        cmbGenre.getSelectionModel().selectFirst();
    }


    public void changeCombo(ActionEvent actionEvent) {

    }

    public void AddUserAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(HelloApplication.class.getResource("UTSSecondPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("modal");
        stage.setScene(scene);
        stage.show();
    }
    public void refreshData() {
        ulist = userDao.getData();
        lvUser.setItems(ulist);
    }
    public void DelUserAction(ActionEvent actionEvent) {
        User selectedUser;
        selectedUser = lvUser.getSelectionModel().getSelectedItem();

        UserDao dao = new UserDao();
        int hasil = dao.delData(selectedUser);
        if (hasil > 0) {
            Alert alertbox = new Alert(Alert.AlertType.INFORMATION, "berhasil hapus");
            alertbox.showAndWait();
        }
        refreshData();

    }

    public void printReport(ActionEvent actionEvent) {
//        throws JRException {
//        Map parameter = new HashMap();
//        JasperPrint jasperPrint = JasperFillManager.fillReport("report/reeport1.jasper", parameter, connection);
//        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
//        jasperViewer.setVisible(true);
    }
}
