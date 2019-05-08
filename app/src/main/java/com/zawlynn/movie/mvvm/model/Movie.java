package com.zawlynn.movie.mvvm.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

@Entity(tableName = "movies")
public class Movie {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private
    long id;
    @ColumnInfo(name = "vote_count")
    private
    int vote_count;
    @ColumnInfo(name = "video")
    private
    boolean video;
    @ColumnInfo(name = "vote_average")
    private
    double vote_average;
    @ColumnInfo(name = "title")
    private
    String title;
    @ColumnInfo(name = "popularity")
    private
    double popularity;
    @ColumnInfo(name = "poster_path")
    private
    String poster_path;
    @ColumnInfo(name = "original_language")
    private
    String original_language;
    @ColumnInfo(name = "original_title")
    private
    String original_title;
    @ColumnInfo(name = "backdrop_path")
    private
    String backdrop_path;
    @ColumnInfo(name = "adult")
    private
    boolean adult;
    @ColumnInfo(name = "overview")
    private
    String overview;
    @ColumnInfo(name = "release_date")
    private
    String release_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        Movie user = (Movie) obj;

        return user.getId() == this.getId() && user.getTitle() == this.getTitle();
    }
}
