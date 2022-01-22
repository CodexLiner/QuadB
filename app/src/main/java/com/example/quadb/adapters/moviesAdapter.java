package com.example.quadb.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quadb.MyModels.MyModel;
import com.example.quadb.R;
import com.example.quadb.UI.detailsActivity;
import com.example.quadb.constant;

import java.io.Serializable;
import java.util.List;

public class moviesAdapter extends RecyclerView.Adapter<moviesAdapter.holder> implements Serializable {
    List<MyModel> mList;

    public moviesAdapter(List<MyModel> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row , parent , false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String posterUrl;
        if (mList.get(position).getShow().getImage()!=null){
             posterUrl = mList.get(position).getShow().getImage().getOriginal();
        }else {
            posterUrl = mList.get(position).getShow().getImage().getMedium();

        }
        String summary = mList.get(position).getShow().getSummary();
        String title = mList.get(position).getShow().getName();
        String rating = mList.get(position).getShow().getRating().getAverage();
        Log.d("TAG", "onBindViewHolder: "+posterUrl);

        if (rating != null){
            String rate = "✦ "+rating;
            holder.mRating.setText(rate);
        }
        holder.mTitle.setText(title);
        holder.mSumm.setText(summary);
        Glide.with(holder.poster).load(posterUrl).placeholder(R.drawable.poster).into(holder.poster);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext() , detailsActivity.class);
//                intent.putExtra("list" ,  mList.get(position).getShow());
                constant.model =  mList.get(position).getShow();
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class holder extends RecyclerView.ViewHolder implements Serializable {
        ImageView poster;
        LinearLayout layout;
        TextView mTitle , mSumm , mRating;
        public holder(@NonNull View itemView) {
            super(itemView);
            mSumm = itemView.findViewById(R.id.mDesc);
            mTitle = itemView.findViewById(R.id.mTitle);
            mRating = itemView.findViewById(R.id.mRate);
            poster = itemView.findViewById(R.id.moviePoster);
            layout = itemView.findViewById(R.id.recLayout);
        }
    }
}
