package com.tony.dbmovie.api;

import com.tony.dbmovie.data.MovieResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dev on 2/1/18.
 */

public interface MoviesListApi {

    @GET("in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<MovieResult> getMovieList(@Query("city") String aCity,@Query("start") int aStart,@Query("count") int aCount);
}
