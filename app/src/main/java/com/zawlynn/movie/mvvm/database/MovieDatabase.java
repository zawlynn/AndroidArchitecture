package com.zawlynn.movie.mvvm.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.zawlynn.movie.mvvm.database.dao.MovieDao;
import com.zawlynn.movie.mvvm.model.Movie;

@Database(entities = {Movie.class}, version = 2, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
    static MovieDatabase instance;
    public static MovieDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,MovieDatabase.class,"movies.db").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
