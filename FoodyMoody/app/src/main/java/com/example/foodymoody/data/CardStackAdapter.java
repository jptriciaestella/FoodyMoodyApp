package com.example.foodymoody.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodymoody.R;

import java.util.Collections;
import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<Food> items;

    public CardStackAdapter(List<Food> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.food_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateReceiptsList(List<Food> newlist) {
        items.clear();
        items.addAll(newlist);
        this.notifyDataSetChanged();
        System.out.println("MASUK");
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, desc;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.food_image);
            name = itemView.findViewById(R.id.food_name);
            desc = itemView.findViewById(R.id.food_desc);
        }

        void setData(Food data) {
            Glide.with(itemView.getContext())
                    .load(data.getImage())
                    .into(image);
            name.setText(data.getName());
            desc.setText(data.getDescription());
        }
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}