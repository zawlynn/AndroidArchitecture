package com.zawlynn.movie.mvvm.network.response;

import com.google.gson.annotations.SerializedName;
import com.zawlynn.movie.mvvm.model.Movie;

import java.util.List;

public class PopularResponse {
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_pages")
    private int total_pages;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
