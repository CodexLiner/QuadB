package com.example.quadb.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.quadb.MyModels.MyModel;
import com.example.quadb.R;
import com.example.quadb.adapters.moviesAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class searchActivity extends AppCompatActivity {
    BottomNavigationView bottomView;
    RecyclerView recyclerView;
    Button button;
    ImageView imageView;
    EditText searchEdit;
    moviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bottomView = findViewById(R.id.bottomView);
        button = findViewById(R.id.BtnSearch);
        recyclerView = findViewById(R.id.sRec);
        searchEdit = findViewById(R.id.searchText);
        imageView = findViewById(R.id.imgT);
        bottomView.setSelectedItemId(R.id.mSearch);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(lm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stext = searchEdit.getText().toString().trim();
                if (TextUtils.isEmpty(stext)){
                    searchEdit.setError("Enter Text");
                    return;
                }
                getData(stext);
            }
        });



        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mHome:{
                       finish();
                       overridePendingTransition(0,0);
                    }
                    case R.id.mSearch:{
                       return true;
                    }
                }
                return false;
            }
        });
    }

    private void getData(String stext) {
        Gson gson = new Gson();
        Request request = new Request.Builder().url("https://api.tvmaze.com/search/shows?q="+stext).get().build();
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
                        imageView.setVisibility(View.GONE);
                        adapter = new moviesAdapter(model);
                        recyclerView.setAdapter(adapter);
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,0);
    }
}