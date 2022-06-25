package com.example.foodymoody.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodymoody.DetailFoodActivity;
import com.example.foodymoody.Favorite;
import com.example.foodymoody.R;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    ArrayList<FavoriteFood> favoriteFoods;

    public FavoriteAdapter(ArrayList<FavoriteFood> list) {
        this.favoriteFoods = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favorite_food_row, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(favoriteFoods.get(position));
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return favoriteFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public int position;
        ImageView image;
        TextView name, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.favorite_img);
            name = itemView.findViewById(R.id.favorite_name);
            date = itemView.findViewById(R.id.favorite_date);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent myIntent = new Intent(v.getContext(), DetailFoodActivity.class);
                    myIntent.putExtra("likedFood", favoriteFoods.get(position).getFood());
                    v.getContext().startActivity(myIntent);
                }
            });

            itemView.findViewById(R.id.delete_favorite_button).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    FavoriteFood.list.remove(position);
                    SharedPreferences sharedPreferences = v.getContext().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();

                    String json = gson.toJson(FavoriteFood.list);
                    editor.putString("favorites", json);

                    editor.apply();

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    Fragment myFragment = new Favorite();
                    notifyItemRemoved(position);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment, myFragment).addToBackStack(null).commit();
                }
            });
        }

        public void setData(FavoriteFood favoriteFood) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

            Glide.with(itemView.getContext())
                    .load(favoriteFood.getFood().getImage())
                    .into(image);
            name.setText(favoriteFood.getFood().getName());
            date.setText("Added: " + formatter.format(favoriteFood.getAdded()));
        }
    }
}
