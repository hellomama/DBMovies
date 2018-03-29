package com.tony.dbmovie.api;

import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bushi on 2018/3/24.
 */

public interface CelebrityApi {
    @GET("v2/movie/celebrity/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<Celebrity> getCelebrity(@Path("id") String id);

    @GET("v2/movie/celebrity/{id}/works?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<WorkResult> getWorks(@Path("id") String id);

    @GET("v2/movie/celebrity/{id}/photos?apikey=0b2bdeda43b5688921839c8ecb20399b")
    Flowable<PhotoResult> getPhotos(@Path("id") String id);
}
