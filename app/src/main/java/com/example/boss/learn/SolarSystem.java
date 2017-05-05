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

public class SolarSystem extends AppCompatActivity {

    String shape_name[]={"sun","MERCURY","VENUS","EARTH","MARS","JUPITER","SATURN","URANUS","NEPTUNE"};
    int images[]={R.drawable.sunn,R.drawable.mercury,R.drawable.vinus,R.drawable.earth,
            R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.nuptune};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_system);
        MainActivity.toSpeech.speak(shape_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
    }

    public void onClickPrevious(View view)
    {
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
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
        MainActivity.toSpeech.speak(shape_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
    }

    public void onClickNext(View view)
    {
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber<8){
            pageNumber++;
            t2.setText(shape_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
        }
        MainActivity.toSpeech.speak(shape_name[pageNumber],TextToSpeech.QUEUE_FLUSH,null);
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
