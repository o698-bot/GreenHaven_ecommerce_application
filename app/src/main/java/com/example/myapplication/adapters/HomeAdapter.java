package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.activities.ViewAllActivity;
import com.example.myapplication.models.HomeCatergory;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<HomeCatergory> catergoryList;

    public HomeAdapter(Context context, List<HomeCatergory> catergoryList) {
        this.context = context;
        this.catergoryList = catergoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cat_items,parent,false));

    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(context).load(catergoryList.get(position).getImg_url()).into(holder.catImg);
//        holder.name.setText(catergoryList.get(position).getName());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ViewAllActivity.class);
//                intent.putExtra("type",catergoryList.get(position).getType());
//                context.startActivity(intent);
//            }
//        });
//
//    }
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    HomeCatergory category = catergoryList.get(position);

    Glide.with(context).load(category.getImg_url()).into(holder.catImg);
    holder.name.setText(category.getName());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                HomeCatergory clickedItem = catergoryList.get(adapterPosition);
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("type", clickedItem.getType());
                context.startActivity(intent);
            }
        }
    });
}


    @Override
    public int getItemCount() {
        return catergoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImg = itemView.findViewById(R.id.home_cat_img);
            name = itemView.findViewById(R.id.cat_home_name);

        }
    }
}
