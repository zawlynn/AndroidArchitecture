package com.zawlynn.movie.mvvm.ui;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.zawlynn.movie.mvvm.network.Resource;
import com.zawlynn.movie.mvvm.repository.ApiRepository;
import com.zawlynn.movie.mvvm.repository.RepoLocalSource;

public class MainViewModel extends AndroidViewModel {
    ApiRepository repository;
    RepoLocalSource localSource;
    MutableLiveData movies = new MutableLiveData();

    public MainViewModel(@NonNull Application application) {
        super(application);
        localSource = RepoLocalSource.getInstance(application);
        repository = new ApiRepository(localSource);
    }

    @SuppressLint("CheckResult")
    public void getPopularMoive(Context context) {
        repository.getPopularMovies(context)
                .subscribe(resource -> {
                    if (resource.data != null) {
                        Log.d("MOVIE REPOSITORY","GET DATA "+resource.data.size());
                        movies.postValue(resource.data);
                    }
                    if (resource.status == Resource.Status.LOADING) {
                        Log.d("MOVIE REPOSITORY", "LOADING");
                    } else if (resource.status == Resource.Status.SUCCESS) {
                        Log.d("MOVIE REPOSITORY", "SUCCESS");
                    } else if (resource.status == Resource.Status.ERROR) {
                        Log.d("MOVIE REPOSITORY", "ERROR");
                    }

                });
    }
}
