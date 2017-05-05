package com.example.boss.learn;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static int itemSelected=0;
    private List<Images> imageList = new ArrayList<>();
    public RecyclerView recyclerView;
    public ImageAdapter mAdapter;
    static TextToSpeech toSpeech;
    static int result;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.right_side_in, R.anim.right_slide_out);
        toSpeech = new TextToSpeech(this,new TextToSpeech.OnInitListener(){
            public void onInit(int status)
            {
                if(status==TextToSpeech.SUCCESS)                    result=toSpeech.setLanguage(Locale.UK);
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not support in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new ImageAdapter(imageList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                itemSelected=position;
            }
            @Override
            public void onLongClick(View view, int position) {
                itemSelected=position;
            }
        }));

        prepareMovieData();

    }

    public void A(View view) {
        if(itemSelected==0)
        {
            Intent i = new Intent(this, Abc.class);
            startActivity(i);
        }
        else if(itemSelected==1)
        {
            Intent i = new Intent(this, Shape.class);
            startActivity(i);
        }
        else if(itemSelected==2)
        {
            Intent i = new Intent(this, Animal.class);
            startActivity(i);
        }
        else if(itemSelected==3)
        {
            Intent i = new Intent(this, Fruit.class);
            startActivity(i);
        }
        else if(itemSelected==4)
        {
            Intent i = new Intent(this, Flower.class);
            startActivity(i);
        }
        else if(itemSelected==5)
        {
            Intent i = new Intent(this, Test.class);
            startActivity(i);
        }
        overridePendingTransition(R.anim.from_middle, R.anim.in_middle);
    }

    public void B(View view) {
        if(itemSelected==0)
        {
            Intent i = new Intent(this, oneTwoThree.class);
            startActivity(i);
        }
        else if(itemSelected==1)
        {
            Intent i = new Intent(this, Color.class);
            startActivity(i);
        }
        else if(itemSelected==2)
        {
            Intent i = new Intent(this, Bird.class);
            startActivity(i);
        }
        else if(itemSelected==3)
        {
            Intent i = new Intent(this, Vegetable.class);
            startActivity(i);
        }
        else if(itemSelected==4)
        {
            Intent i = new Intent(this, SolarSystem.class);
            startActivity(i);
        }
        else if(itemSelected==5)
        {
            Intent i = new Intent(this, Developer.class);
            startActivity(i);
        }
        overridePendingTransition(R.anim.from_middle, R.anim.in_middle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.navigation_abcd:
                Intent i = new Intent(this, Abc.class);
                startActivity(i);
                return true;
            case R.id.navigation_onetwothree:
                 i = new Intent(this, oneTwoThree.class);
                startActivity(i);
                return true;
            case R.id.navigation_shape:
                 i = new Intent(this, Shape.class);
                startActivity(i);
                return true;
            case R.id.navigation_color:
                 i = new Intent(this, Color.class);
                startActivity(i);
                return true;
            case R.id.navigation_animal:
                 i = new Intent(this, Animal.class);
                startActivity(i);
                return true;
            case R.id.navigation_bird:
                 i = new Intent(this, Bird.class);
                startActivity(i);
                return true;
            case R.id.navigation_fruit:
                 i = new Intent(this, Fruit.class);
                startActivity(i);
                return true;
            case R.id.navigation_vegetable:
                 i = new Intent(this, Vegetable.class);
                startActivity(i);
                return true;
            case R.id.navigation_flower:
                 i = new Intent(this, Flower.class);
                startActivity(i);
                return true;
            case R.id.navigation_solarsystem:
                 i = new Intent(this, SolarSystem.class);
                startActivity(i);
                return true;
            case R.id.navigation_test:
                 i = new Intent(this, Test.class);
                startActivity(i);
                return true;
            case R.id.navigation_developer:
                 i = new Intent(this, Developer.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void prepareMovieData() {
        Images img = new Images(R.drawable.abcd,R.drawable.onetwothree);
        imageList.add(img);
        img = new Images(R.drawable.shapes,R.drawable.color);
        imageList.add(img);
        img = new Images(R.drawable.animals,R.drawable.birds);
        imageList.add(img);
        img = new Images(R.drawable.fruits,R.drawable.vegitables);
        imageList.add(img);
        img = new Images(R.drawable.flowers,R.drawable.planets);
        imageList.add(img);
        img = new Images(R.drawable.test,R.drawable.developer);
        imageList.add(img);
    }
}
