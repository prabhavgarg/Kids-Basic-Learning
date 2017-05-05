package com.example.boss.learn;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class oneTwoThree extends AppCompatActivity {

    String numbers[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    String numbers_name[]={"one","two","THREE","FOUR","FIVE","six","SEVEN","EIGHT","NINE","ten","ELEVEN","TWELVE","THIRTEEN"
            ,"FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN","TWENTY"};
    int images[]={R.drawable.apple,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,
            R.drawable.kite,R.drawable.lion,R.drawable.monkey,R.drawable.nose,R.drawable.orange,R.drawable.parrot,
            R.drawable.queen,R.drawable.rat,R.drawable.sun,R.drawable.tree,R.drawable.unicorn,R.drawable.van,
            R.drawable.wheel,R.drawable.x_ray,R.drawable.yak,R.drawable.zebra,R.drawable.zebra,R.drawable.zebra};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_two_three);
        MainActivity.toSpeech.speak(numbers_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
    }

    public void onClickPrevious(View view)
    {
        TextView t1 = (TextView)findViewById(R.id.alphabet);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber>0){
            pageNumber--;
            t1.setText(numbers[pageNumber]);
            t2.setText(numbers_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
        }
        MainActivity.toSpeech.speak(numbers_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
    }

    public void onClickNext(View view)
    {
        TextView t1 = (TextView)findViewById(R.id.alphabet);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber<9){
            pageNumber++;
            t1.setText(numbers[pageNumber]);
            t2.setText(numbers_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
        }
        MainActivity.toSpeech.speak(numbers_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onPlay(View view)
    {
        switch (view.getId())
        {
            case R.id.play:
                if(MainActivity.result==TextToSpeech.LANG_MISSING_DATA||MainActivity.result==TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(),"Feature not support in your device",Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity.toSpeech.speak(numbers_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
        }
    }
}
