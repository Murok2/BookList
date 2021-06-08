package com.minix.aidaraly.booklist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Generator
{
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl( BASE_URL )
                    .addConverterFactory( GsonConverterFactory.create() );

    public static <S> S getRetrofitInstance(Class<S> serviceClass) {
        if (retrofit==null) {
           retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}
