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

public class Color extends AppCompatActivity {

    String shape_name[]={"BLUE","GREEN","red","YELLOW","WHITE","BLACK","GREY","ORANGE","PURPLE","BROWN",
            "PINK","MAGENTA","SILVER","GOLD"};
    int color[]={R.color.blue,R.color.green,R.color.red,R.color.yellow,R.color.white,R.color.black,R.color.grey,
            R.color.orange,R.color.purple,R.color.brown,R.color.pink,R.color.magenta,R.color.slver,R.color.gold};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void onClickPrevious(View view)
    {
        TextView t1 = (TextView) findViewById(R.id.alphabet_image);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        if(pageNumber>0){
            pageNumber--;
            t2.setText(shape_name[pageNumber]);
            t1.setBackgroundResource(color[pageNumber]);
        }
        if(MainActivity.toSpeech!=null)
        {
            MainActivity.toSpeech.stop();
        }
    }

    public void onClickNext(View view)
    {
        TextView t1 = (TextView) findViewById(R.id.alphabet_image);
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        if(pageNumber<13){
            pageNumber++;
            t2.setText(shape_name[pageNumber]);
            t1.setBackgroundResource(color[pageNumber]);
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
