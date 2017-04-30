package com.example.boss.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Shape extends AppCompatActivity {

    String shape_name[]={"SQUARE","RECTANGLE","CIRCLE","TRIANGLE","OVAL","PENTAGON","HEXAGON","OCTAGON","CUBE","SPHERE",
            "CYLINDER","CONE","PRISM","PYRAMID"};
    int images[]={R.drawable.square,R.drawable.rectanlge,R.drawable.circle,R.drawable.triangle,
            R.drawable.oval,R.drawable.pentagon,R.drawable.hexagon,R.drawable.octagon,R.drawable.cube,R.drawable.sphere,
            R.drawable.cylinder,R.drawable.cone,R.drawable.prism,R.drawable.pyramid};
    int pageNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
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
    }

    public void onClickNext(View view)
    {
        TextView t2 = (TextView)findViewById(R.id.alphabet_name);
        ImageView imageView = (ImageView) findViewById(R.id.alphabet_image);
        if(pageNumber<13){
            pageNumber++;
            t2.setText(shape_name[pageNumber]);
            imageView.setImageResource(images[pageNumber]);
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

}
