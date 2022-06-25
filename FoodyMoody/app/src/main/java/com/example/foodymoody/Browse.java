package com.example.foodymoody;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.foodymoody.data.CardStackAdapter;
import com.example.foodymoody.data.FavoriteFood;
import com.example.foodymoody.data.Food;
import com.example.foodymoody.data.model.AngryFood;
import com.example.foodymoody.data.model.HappyFood;
import com.example.foodymoody.data.model.MehFood;
import com.example.foodymoody.data.model.SadFood;
import com.google.gson.Gson;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Browse extends Fragment{

    String mood = "Empty";
    LinearLayout moodInput, noInternet, foundFood;
    ImageButton currMood, angryButton, sadButton, mehButton, happyButton, closeButton,
                skipButton, likeButton, rewindButton;
    ImageView congratsGif;
    CardStackLayoutManager manager;
    CardStackAdapter adapter = new CardStackAdapter(addList());
    Integer index = 0;

    public Browse() {
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
        View rootView = inflater.inflate(R.layout.fragment_browse, container, false);

        moodInput = rootView.findViewById(R.id.mood_input);

        angryButton = rootView.findViewById(R.id.mood_button_angry);
        sadButton = rootView.findViewById(R.id.mood_button_sad);
        mehButton = rootView.findViewById(R.id.mood_button_meh);
        happyButton = rootView.findViewById(R.id.mood_button_happy);
        currMood = rootView.findViewById(R.id.curr_mood);
        closeButton = rootView.findViewById(R.id.close_mood_input);
        skipButton = rootView.findViewById(R.id.skip_button);
        likeButton = rootView.findViewById(R.id.like_button);
        noInternet = rootView.findViewById(R.id.no_internet);
        foundFood = rootView.findViewById(R.id.found_food);
        congratsGif = rootView.findViewById(R.id.congrats_gif);
        rewindButton = rootView.findViewById(R.id.rewind_button);

        CardStackView cardStackView = rootView.findViewById(R.id.card_stack_view);

        Glide.get(getContext()).clearMemory();

        final MediaPlayer yaySound = MediaPlayer.create(getContext(), R.raw.yay_sound);

        //check if user already input mood
        if(mood.equals("Empty")){
            moodInput.setVisibility(View.VISIBLE);
            closeButton.setVisibility(View.GONE);
        }else{
            switch (mood){
                case "angry":
                    currMood.setImageResource(R.drawable.angry);
                    break;
                case "happy":
                    currMood.setImageResource(R.drawable.happy);
                    break;
                case "meh":
                    currMood.setImageResource(R.drawable.meh);
                    break;
                case "sad":
                    currMood.setImageResource(R.drawable.sad);
                    break;
            }
        }

        manager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
            }

            @Override
            public void onCardSwiped(Direction direction) {
                if(direction == Direction.Right){
                    getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    Glide.with(getContext())
                            .load("https://media.baamboozle.com/uploads/images/304997/1636716891_414277_gif-url.gif")
                            .into(congratsGif);
                    foundFood.setVisibility(View.VISIBLE);
                    yaySound.start();
                    
                    addFavoriteFoodList();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            foundFood.setVisibility(View.GONE);
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            Intent myIntent = new Intent(getActivity().getApplicationContext(), DetailFoodActivity.class);
                            myIntent.putExtra("likedFood", adapter.getItems().get(manager.getTopPosition()-1));
                            getActivity().startActivity(myIntent);
                        }
                    }, 2000);
                }
            }

            @Override
            public void onCardRewound() {

            }

            @Override
            public void onCardCanceled() {

            }

            @Override
            public void onCardAppeared(View view, int position) {
                //check if internet is available
                if(isNetworkAvailable()){
                    noInternet.setVisibility(View.GONE);
                }else{
                    noInternet.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                index++;
                System.out.println(index);
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(false);
        manager.setSwipeableMethod((SwipeableMethod.AutomaticAndManual));
        manager.setOverlayInterpolator(new LinearInterpolator());

        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.scrollToPosition(index);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

        angryButton.setOnClickListener(view -> {
            if(!mood.equals("angry")){
                index=0;
                mood="angry";
                adapter.updateReceiptsList(addList());
            }
            moodInput.setVisibility(View.GONE);
            currMood.setImageResource(R.drawable.angry);
        });

        sadButton.setOnClickListener(view -> {
            if(!mood.equals("sad")){
                index=0;
                mood="sad";
                adapter.updateReceiptsList(addList());
            }
            moodInput.setVisibility(View.GONE);
            currMood.setImageResource(R.drawable.sad);
        });

        mehButton.setOnClickListener(view -> {
            if(!mood.equals("meh")){
                index=0;
                mood="meh";
                adapter.updateReceiptsList(addList());
            }
            moodInput.setVisibility(View.GONE);
            currMood.setImageResource(R.drawable.meh);
        });

        happyButton.setOnClickListener(view -> {
            if(!mood.equals("happy")) {
                index = 0;
                mood = "happy";
                currMood.setImageResource(R.drawable.happy);
            }
            moodInput.setVisibility(View.GONE);
            adapter.updateReceiptsList(addList());
        });

        currMood.setOnClickListener(view -> {
            moodInput.setVisibility(View.VISIBLE);
            closeButton.setVisibility(View.VISIBLE);
        });

        closeButton.setOnClickListener(view -> moodInput.setVisibility(View.GONE));

        skipButton.setOnClickListener(view -> {
            SwipeAnimationSetting swipeAnimationSetting = new SwipeAnimationSetting.Builder()
                            .setDirection(Direction.Left)
                            .setDuration(Duration.Normal.duration)
                            .setInterpolator(new LinearInterpolator())
                            .build();
            manager.setSwipeAnimationSetting(swipeAnimationSetting);
            cardStackView.swipe();
        });

        likeButton.setOnClickListener(view -> {
            SwipeAnimationSetting swipeAnimationSetting = new SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Right)
                    .setDuration(Duration.Normal.duration)
                    .setInterpolator(new LinearInterpolator())
                    .build();
            manager.setSwipeAnimationSetting(swipeAnimationSetting);
            cardStackView.swipe();
        });

        rewindButton.setOnClickListener(view -> {
            SwipeAnimationSetting swipeAnimationSetting = new SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Bottom)
                    .setDuration(Duration.Normal.duration)
                    .setInterpolator(new LinearInterpolator())
                    .build();
            manager.setSwipeAnimationSetting(swipeAnimationSetting);
            cardStackView.rewind();
        });

        return rootView;
    }
    
    private void addFavoriteFoodList(){
        Food likedFood = adapter.getItems().get(manager.getTopPosition()-1);

        for (FavoriteFood favoriteFood:FavoriteFood.list) {
            if(favoriteFood.getFood().getName().equals(likedFood.getName())){
                return;
            }
        }
        
        FavoriteFood.list.add(new FavoriteFood(likedFood,
                Calendar.getInstance().getTime()));

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        String json = gson.toJson(FavoriteFood.list);
        editor.putString("favorites", json);

        editor.apply();
    }

    private List<Food> addList() {
        List<Food> items = new ArrayList<>();

        switch (mood){
            case "angry":
                items.addAll(new AngryFood().getList());
                break;
            case "sad":
                items.addAll(new SadFood().getList());
                break;
            case "meh":
                items.addAll(new MehFood().getList());
                break;
            case "happy":
                items.addAll(new HappyFood().getList());
                break;
            default:
                items.add(new Food("Please input your mood!","https://wallpaperaccess.com/full/676550.jpg","No Food Recommendation", 0, false));
        }

        Collections.shuffle(items);

        return items;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}