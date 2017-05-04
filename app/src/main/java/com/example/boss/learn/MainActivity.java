package com.example.boss.learn;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static TextToSpeech toSpeech;
    static int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toSpeech = new TextToSpeech(this,new TextToSpeech.OnInitListener(){
            public void onInit(int status)
            {
                if(status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.UK);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not support in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openAbc(View view) {
        Intent i = new Intent(this, Abc.class);
        startActivity(i);
    }

    public void openOneTwoThree(View view) {
        Intent i = new Intent(this, oneTwoThree.class);
        startActivity(i);
    }

    public void openShape(View view) {
        Intent i = new Intent(this, Shape.class);
        startActivity(i);
    }

    public void openColor(View view) {
        Intent i = new Intent(this, Color.class);
        startActivity(i);
    }

    public void openAnimal(View view) {
        Intent i = new Intent(this, Animal.class);
        startActivity(i);
    }

    public void openFruit(View view) {
        Intent i = new Intent(this, Fruit.class);
        startActivity(i);
    }

    public void openVegetable(View view) {
        Intent i = new Intent(this, Vegetable.class);
        startActivity(i);
    }

    public void openFlower(View view) {
        Intent i = new Intent(this, Flower.class);
        startActivity(i);
    }

    public void openSolarSystem(View view) {
        Intent i = new Intent(this, SolarSystem.class);
        startActivity(i);
    }

    public void openBird(View view) {
        Intent i = new Intent(this, Bird.class);
        startActivity(i);
    }

    public void openTest(View view) {
        Intent i = new Intent(this, Test.class);
        startActivity(i);
    }

    public void openDeveloper(View view) {
        Intent i = new Intent(this, Developer.class);
        startActivity(i);
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

}
