package com.example.boss.learn;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RawRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Abc extends AppCompatActivity {

    String alphabets[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String alphabet_name[]={"APPLE","BALL","cat","dog","egg","FISH","gun","HORSE","IRON","jug","KITE","LION","MONKEY"
            ,"NOSE","ORANGE","PARROT","QUEEN","rat","sun","TREE","UNICORN","van","WHEEL","X-ray","yak","ZEBRA"};
    String alphabet_name1[]={"APPLE","BALL","cat","dog","egg","FISH","gun","HORSE","IRON","jug","KITE","LION","MONKEY"
            ,"NOSE","ORANGE","PARROT","QUEEN","rat","sun","TREE","UNICORN","van","WHEEL","X ray","yak","ZEBRA"};
    int images[]={R.drawable.apple,R.drawable.ball,R.drawable.cat,R.drawable.dog,
            R.drawable.egg,R.drawable.fish,R.drawable.gun,R.drawable.horse,R.drawable.iron,R.drawable.jug,
            R.drawable.kite,R.drawable.lion,R.drawable.monkey,R.drawable.nose,R.drawable.orange,R.drawable.parrot,
            R.drawable.queen,R.drawable.rat,R.drawable.sun,R.drawable.tree,R.drawable.unicorn,R.drawable.van,
            R.drawable.wheel,R.drawable.x_ray,R.drawable.yak,R.drawable.zebra};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);
    }

    public void onClickPrevious(View view)
    {
        TextView t1 = (TextView)findViewById(R.id.alphabet);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber>0){
            pageNumber--;
            t1.setText(alphabets[pageNumber]);
            t2.setText(alphabet_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
            if(MainActivity.toSpeech!=null)
            {
                MainActivity.toSpeech.stop();
            }
        }
    }

    public void onClickNext(View view)
    {
        TextView t1 = (TextView)findViewById(R.id.alphabet);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber<25){
            pageNumber++;
            t1.setText(alphabets[pageNumber]);
            t2.setText(alphabet_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
            if(MainActivity.toSpeech!=null)
            {
                MainActivity.toSpeech.stop();
            }
        }
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
                    MainActivity.toSpeech.speak(alphabet_name1[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
        }
    }
}
