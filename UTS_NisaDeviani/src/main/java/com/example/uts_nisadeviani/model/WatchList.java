package com.example.uts_nisadeviani.model;

public class WatchList {
    private Integer idWatchList;
    private Integer LastWatch;
    private Integer Favorite;
    private Integer Movie_idMovie;
    private Integer User_idUser;



    public WatchList(Integer idWatchList, Integer lastWatch, Integer favorite, Integer movie_idMovie, Integer user_idUser) {
        this.idWatchList = idWatchList;
        LastWatch = lastWatch;
        Favorite = favorite;
        Movie_idMovie = movie_idMovie;
        User_idUser = user_idUser;
    }

    public Integer getIdWatchList() {
        return idWatchList;
    }

    public void setIdWatchList(Integer idWatchList) {
        this.idWatchList = idWatchList;
    }

    public Integer getLastWatch() {
        return LastWatch;
    }

    public void setLastWatch(Integer lastWatch) {
        LastWatch = lastWatch;
    }

    public Integer getFavorite() {
        return Favorite;
    }

    public void setFavorite(Integer favorite) {
        Favorite = favorite;
    }

    public Integer getMovie_idMovie() {
        return Movie_idMovie;
    }

    public void setMovie_idMovie(Integer movie_idMovie) {
        Movie_idMovie = movie_idMovie;
    }

    public Integer getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(Integer user_idUser) {
        User_idUser = user_idUser;
    }
}
