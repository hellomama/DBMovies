package com.tony.dbmovie.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dev on 2/1/18.
 */

public interface CommentApi {

    @GET("v2/movie/subject/{id}/comments?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<Object> getMovieComment(@Path("id") String movieId, @Query("start") int aStart, @Query("count") int aCount);
}
