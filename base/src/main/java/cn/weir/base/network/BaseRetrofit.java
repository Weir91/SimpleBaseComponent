package cn.weir.base.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofit {

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .callTimeout(15L, TimeUnit.SECONDS)
                .connectTimeout(15L, TimeUnit.SECONDS)
                .readTimeout(15L, TimeUnit.SECONDS)
                .writeTimeout(15L, TimeUnit.SECONDS)
                .addInterceptor(OkHttpInterceptor.getHttpLoggingInterceptor(true))
                .build();
        return client;
    }

    public static Retrofit getRetrofit(String baseUrl) {
        return getRetrofit(baseUrl, getOkHttpClient());
    }

    public static Retrofit getRetrofit(String baseUrl, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}