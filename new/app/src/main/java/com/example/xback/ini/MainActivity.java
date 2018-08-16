package com.example.xback.ini;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog progressDialog;
    private ListView listView;

//    URL to contacts JSON
    private static String URL = "https://www.googleapis.com/books/v1/volumes?q=%7Bkeyword";

    ArrayList<HashMap<String, String>> booklist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booklist = ArrayList<>();

        listView = (ListView) findViewById(R.id.listViewMain);

        new GetBooks().execute();
    }

//    Async Task to call JSON

    private class GetBooks extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void onPrexecute(){
            super.onPreExecute();
//            showing progress dialog
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0){
            HttpHandler sh = new HttpHandler();

//            make a request to URL and getting response
            String jsonString = sh.makeServiceCall(URL);

            Log.e(TAG, "Response from URL: " + jsonString);

            if (jsonString != null){
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);

//                    Getting array node
                    JSONArray items = jsonObject.getJSONArray("items");
                    int length = jsonObject.length();

//                    looping
                    for (int i = 0; i < length(); i++){
                        JSONObject b = items.getJSONObject(i);

                        String name = b.getString()
                    }

                }
            }
        }
    }
}
