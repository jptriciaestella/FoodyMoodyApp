package com.example.foodymoody;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.foodymoody.data.FavoriteAdapter;
import com.example.foodymoody.data.FavoriteFood;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Favorite extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter = new FavoriteAdapter(FavoriteFood.list);
    LinearLayout noFavorite, favoriteList;

    public Favorite() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);

        mRecyclerView = rootView.findViewById(R.id.favorite_recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        noFavorite = rootView.findViewById(R.id.no_favorite);
        favoriteList = rootView.findViewById(R.id.favorite_list);

        loadData();
        mAdapter.notifyDataSetChanged();

        if (FavoriteFood.list.isEmpty()){
            noFavorite.setVisibility(View.VISIBLE);
            favoriteList.setVisibility(View.GONE);
        }else{
            noFavorite.setVisibility(View.GONE);
            favoriteList.setVisibility(View.VISIBLE);
        }

        return rootView;
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String json = sharedPreferences.getString("favorites", null);

        Type type = new TypeToken<ArrayList<FavoriteFood>>() {}.getType();

        FavoriteFood.list = gson.fromJson(json, type);

        if (FavoriteFood.list == null) {
            FavoriteFood.list = new ArrayList<>();
        }
    }

}