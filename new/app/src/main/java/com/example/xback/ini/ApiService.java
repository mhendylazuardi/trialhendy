package com.example.xback.ini;

import com.example.xback.ini.model.Book;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("books/v1/volumes")
    Call<Book> getBook(@Query("q") String keyword);
}
