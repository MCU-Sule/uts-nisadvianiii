package com.example.uts_nisadeviani.model;

public class Movie {
    private Integer idMovie;
    private String Title;
    private String Genre;
    private Integer Durasi;

    @Override
    public String toString() {
        return Genre;
    }

    public Movie(Integer idMovie, String title, String genre, Integer durasi) {
        this.idMovie = idMovie;
        Title = title;
        Genre = genre;
        Durasi = durasi;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Integer getDurasi() {
        return Durasi;
    }

    public void setDurasi(Integer durasi) {
        Durasi = durasi;
    }
}
