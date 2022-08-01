package com.example.uts_nisadeviani.dao;

import javafx.collections.ObservableList;

public interface DaoInterface<T> {
    ObservableList<T> getData();
    void addData(T data);
    void updateData(T data);
    int delData(T data);
}
