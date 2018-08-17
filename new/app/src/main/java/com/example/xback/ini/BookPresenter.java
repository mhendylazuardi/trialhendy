package com.example.xback.ini;

import com.example.xback.ini.model.Book;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookPresenter {
    private final BookView bookView;
    public BookPresenter (BookView bookView){
        this.bookView = bookView;
    }

    public void getBook(String keyword){
        bookView.getBookLoading(true);
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Book> call = apiService.getBook(keyword);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book book = response.body();
                if (book != null){
                    bookView.getBookLoading(false);
                    bookView.getBookSuccess(book);

                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                bookView.getBookLoading(false);
                bookView.getBookFailure("Something Error");
            }
        });
    }
}

