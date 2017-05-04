package com.example.boss.learn;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
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

import static com.example.boss.learn.R.id.alphabet_name;

public class Animal extends AppCompatActivity {

    String shape_name[]={"cat","dog","elephant","FROG","GIRAFFE","LION","RABBIT","HORSE","TIGER","pig",
            "DEER","SNAKE","ZEBRA","KANGAROO","WHALE"};
    int images[]={R.drawable.cat,R.drawable.dogg,R.drawable.elephant,R.drawable.frog,
            R.drawable.giraffe,R.drawable.lion,R.drawable.rabbit,R.drawable.horse,R.drawable.tiger,R.drawable.pig,
            R.drawable.deer,R.drawable.snake,R.drawable.zebra,R.drawable.kangaroo,R.drawable.whale};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
    }

    public void onClickPrevious(View view)
    {
        TextView t2 = (TextView)findViewById(alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber>0){
            pageNumber--;
            t2.setText(shape_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
        }
    }

    public void onClickNext(View view)
    {
        TextView t2 = (TextView)findViewById(alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber<14){
            pageNumber++;
            t2.setText(shape_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
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
                    MainActivity.toSpeech.speak(shape_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
        }
    }
}
