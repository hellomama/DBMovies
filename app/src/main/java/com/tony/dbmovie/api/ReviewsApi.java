package com.tony.dbmovie.api;

import com.tony.dbmovie.data.MovieResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dev on 2/1/18.
 */

public interface ReviewsApi {

    @GET("v2/movie/subject/comment/{id}/comments?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<MovieResult> getMovieReviews(@Path("id") String movieId, @Query("start") int aStart, @Query("count") int aCount);
}
