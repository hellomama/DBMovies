package com.tony.dbmovie.network;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dev on 2/2/18.
 */

public class NetworkHelper {

    private static final String BASE_URL = "https://api.douban.com/";

    private static final Object object = new Object();
    private static NetworkHelper ourInstance ;
    private Map<Class, Object> apis = new HashMap<>();
    private Retrofit retrofit;

    public static NetworkHelper getInstance() {

        if (ourInstance == null)
        {
            synchronized (object)
            {
                ourInstance = new NetworkHelper();
            }
        }
        return ourInstance;
    }

    private NetworkHelper() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T>T createApi(Class<T> service) {
        if (!apis.containsKey(service)) {
            T instance = retrofit.create(service);
            apis.put(service, instance);
        }
        return (T)apis.get(service);
    }
}
