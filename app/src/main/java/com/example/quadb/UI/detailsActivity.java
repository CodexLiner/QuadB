package com.example.quadb.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.quadb.MyModels.model;
import com.example.quadb.R;
import com.example.quadb.adapters.genresAdapter;
import com.example.quadb.constant;
import com.example.quadb.databinding.ActivityDetailsBinding;

import java.io.Serializable;
import java.util.List;

public class detailsActivity extends AppCompatActivity implements Serializable {
ActivityDetailsBinding binding;
ImageView poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        poster = findViewById(R.id.poster);
        List<String> genList;
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        genresAdapter adapter;
        try {
            model myModel = constant.model;
            binding.movieTitle.setText(myModel.getName());
            binding.mDate.setText(myModel.getPremiered());
            binding.summary.setText(myModel.getSummary());
            Glide.with(poster).load(myModel.getImage().getOriginal()).placeholder(R.drawable.poster).into(poster);

            binding.status.setText(myModel.getStatus());
            binding.runTime.setText(myModel.getRuntime());
            binding.type.setText(myModel.getType());
            binding.lang.setText(myModel.getLanguage());

            genList = myModel.getGenres();
            adapter = new genresAdapter(genList);
            binding.genres.setLayoutManager(lm);
            binding.genres.setAdapter(adapter);

            binding.searchIC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext() , searchActivity.class));
                    overridePendingTransition(0,0);
                }
            });

        }catch (Exception e){}
    }
}