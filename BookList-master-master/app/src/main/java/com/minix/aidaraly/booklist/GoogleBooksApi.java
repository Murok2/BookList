package com.minix.aidaraly.booklist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksApi
    {

        @GET("volumes")
        Call<Items> getBooks(@Query("q") String title );

}
