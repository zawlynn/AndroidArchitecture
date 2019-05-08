package com.zawlynn.movie.mvvm.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.zawlynn.movie.mvvm.constant.Constants;
import com.zawlynn.movie.mvvm.model.Movie;
import com.zawlynn.movie.mvvm.network.ApiServices;
import com.zawlynn.movie.mvvm.network.NetworkBoundResource;
import com.zawlynn.movie.mvvm.network.Resource;
import com.zawlynn.movie.mvvm.network.RetrofitClient;
import com.zawlynn.movie.mvvm.network.response.PopularResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public class ApiRepository {
    private RepoLocalSource repoLocalSource;
    public ApiRepository(RepoLocalSource repoLocalSource) {
        this.repoLocalSource=repoLocalSource;
    }
    @SuppressLint("CheckResult")
    public Flowable<Resource<List<Movie>>>  getPopularMovies(Context context) {
        return new  NetworkBoundResource<List<Movie>, PopularResponse>(context) {
            @Override
            protected void saveCallResult(PopularResponse request) {
                Log.d("MOVIE REPOSITORY","Save Call Result");
                 repoLocalSource.saveMovies(request.getResults());
            }

            @Override
            protected Flowable<List<Movie>> loadFromDb() {
                Log.d("MOVIE REPOSITORY","CREATE CALL");
                return repoLocalSource.fetchLocalMovie();
            }

            @Override
            protected Flowable<Response<PopularResponse>> createCall() {
                Log.d("MOVIE REPOSITORY","CREATE CALL");
                return new RetrofitClient().create(Constants.BASE_URL,true).create(ApiServices.class).getNowShowingMovies(Constants.API_KEY);
            }


        }.asFlowable();

    }

}
