package com.zawlynn.movie.mvvm.repository;

import android.app.Application;

import com.zawlynn.movie.mvvm.database.MovieDatabase;
import com.zawlynn.movie.mvvm.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

public class RepoLocalSource {
    private static RepoLocalSource instance;
    private Application application;
    public static RepoLocalSource getInstance(Application application){
        if(instance==null){
            instance=new RepoLocalSource(application);
        }
        return instance;
    }

    RepoLocalSource(Application application) {
        this.application = application;
    }

    void saveMovies(List<Movie> repos) {
        MovieDatabase.getInstance(application).movieDao().saveMovies(repos);
    }

    Flowable<List<Movie>> fetchLocalMovie()
    {
        return MovieDatabase.getInstance(application).movieDao().getAllMovies();
    }
}
