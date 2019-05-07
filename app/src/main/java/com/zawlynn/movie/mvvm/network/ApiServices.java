package com.zawlynn.movie.mvvm.network;

import com.zawlynn.movie.mvvm.network.response.PopularResponse;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("movie/now_playing")
    Flowable<Response<PopularResponse>> getNowShowingMovies(@Query("api_key") String api_key);
}
