package com.example.itpeople_bookstore.api;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookAPI {

    @GET("volumes")
    public String getBooks();
}
