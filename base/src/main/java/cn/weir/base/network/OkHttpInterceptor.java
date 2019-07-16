package cn.weir.base.network;

import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpInterceptor {

    public static HttpLoggingInterceptor getHttpLoggingInterceptor(boolean isDebug) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (isDebug) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return interceptor;
    }
}