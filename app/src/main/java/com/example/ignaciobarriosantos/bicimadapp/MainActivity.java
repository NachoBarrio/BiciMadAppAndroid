package com.example.ignaciobarriosantos.bicimadapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import data.model.BiciMad;
import data.model.remote.ApiService;
import data.model.remote.RetrofitClient;
import data.model.remote.StationList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private View parentView;

    private ArrayList<BiciMad> contactList;
    private MyStationsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Array List for Binding Data from JSON to this List
         */
        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.parentLayout);

                    //Creating an object of our api interface
                    ApiService api = RetrofitClient.getApiService();

                    /**
                     * Calling JSON
                     */
                    Call<StationList> call = api.getStations();

                    /**
                     * Enqueue Callback will be call when get response...
                     */
                    call.enqueue(new Callback<StationList>() {
                        @Override
                        public void onResponse(Call<StationList> call, Response<StationList> response) {


                            if(response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                contactList = response.body().getContacts();

                                /**
                                 * Binding that List to Adapter
                                 */
                                adapter = new MyStationsAdapter(MainActivity.this, contactList);
                                listView.setAdapter(adapter);

                            }
                        }

                        @Override
                        public void onFailure(Call<StationList> call, Throwable t) {
                        }
                    });


    }
}
