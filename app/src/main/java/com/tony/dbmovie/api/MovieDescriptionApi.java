package com.tony.dbmovie.api;

import com.tony.dbmovie.data.MovieDetail;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dev on 2/1/18.
 */

public interface MovieDescriptionApi {

    @GET("v2/movie/subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Observable<MovieDetail> getMovie(@Path("id") String movieId, @Query("city") String city);

}
