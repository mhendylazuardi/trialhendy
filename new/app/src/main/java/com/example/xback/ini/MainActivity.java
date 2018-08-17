package com.example.xback.ini;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.xback.ini.model.Book;
import android.app.SearchManager;
import android.support.v7.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends AppCompatActivity implements BookView {
    private String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

//    URL to contacts JSON
    private static String URL = "https://www.googleapis.com/books/v1/volumes?q=%7Bkeyword";
    private BookAdapter bookAdapter;
    private BookPresenter bookPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpComponent();
        bookPresenter.getBook("Blablabla");
    }

    private void setUpComponent(){
        bookPresenter       = new BookPresenter(this);
        recyclerView        = (RecyclerView) findViewById(R.id.recycleViewBook);
        swipeRefreshLayout  = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshBook);
        bookAdapter         = new BookAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);
    }

    @Override
    public void getBookSuccess(Book book) {
//        masukan data ke adapter
        bookAdapter.addBookItem(book.getItems());
    }

    @Override
    public void getBookFailure(String errorMessage) {
//        nampilin toast
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getBookLoading(boolean isLoading) {
//        laoding
        swipeRefreshLayout.setRefreshing(isLoading);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        if (searchView != null)
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                bookPresenter.getBook(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
