package com.example.quadb.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quadb.MyModels.MyModel;
import com.example.quadb.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.quadb.adapters.moviesAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Serializable {
    RecyclerView mRecycler ;
    moviesAdapter adapter;
    BottomNavigationView bottomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_QuadDB);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.movieRecycler);
        bottomView = findViewById(R.id.bottomView);
        bottomView.setSelectedItemId(R.id.mHome);
        // adding recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false);
        mRecycler.setLayoutManager(layoutManager);
        getData();
        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mHome:{
                        return true;
                    }
                    case R.id.mSearch:{
                        startActivity(new Intent(getApplicationContext() , searchActivity.class));
                        overridePendingTransition(0,0);
                    }
                }
                return false;
            }
        });
    }

    private void getData() {
        Gson gson = new Gson();
        Request request = new Request.Builder().url("https://api.tvmaze.com/search/shows?q=all").get().build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("TAG", "onFailure: failed");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Type listType = new TypeToken<List<MyModel>>() {}.getType();

               List<MyModel> model= gson.fromJson(response.body().string() ,listType);
               Log.d("TAG", "onResponse: "+model.size());
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      adapter = new moviesAdapter(model);
                      mRecycler.setAdapter(adapter);
                  }
              });

            }
        });
    }
}