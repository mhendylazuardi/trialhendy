package com.example.xback.ini;

import com.example.xback.ini.model.Book;

public interface BookView {
//    abstaract method
    void getBookSuccess(Book book);
    void getBookFailure(String errorMessage);
    void getBookLoading(boolean isLoading);


}
