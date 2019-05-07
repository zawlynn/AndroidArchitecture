package com.zawlynn.movie.mvvm.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.zawlynn.movie.mvvm.model.Movie;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveMovie(Movie movie);
    @Query(" SELECT * FROM movies")
    public abstract Flowable<List<Movie>> getAllMovies();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveMovies(List<Movie> movies);
}

