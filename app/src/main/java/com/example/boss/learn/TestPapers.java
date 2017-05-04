package com.example.boss.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TestPapers extends AppCompatActivity {

    int question[]={R.string.q_1,R.string.q_2,R.string.q_3,R.string.q_4,R.string.q_5,R.string.q_6,R.string.q_7,R.string.q_8,
            R.string.q_9,R.string.q_10,R.string.q_11,R.string.q_12,R.string.q_13,R.string.q_14,R.string.q_15,R.string.q_16,
            R.string.q_17,R.string.q_18,R.string.q_19,R.string.q_20,R.string.q_21,R.string.q_22,R.string.q_23,R.string.q_24,
            R.string.q_25,R.string.q_26,R.string.q_27,R.string.q_28,R.string.q_29,R.string.q_30};
    int image[]={R.drawable.frog,R.drawable.giraffe,R.drawable.zebra,R.drawable.penguin,R.drawable.sparrow,R.drawable.kiwis,
            R.drawable.circle,R.drawable.triangle,R.drawable.oval,R.drawable.hibiscus,R.drawable.lily,R.drawable.orchid,
            R.drawable.orange,R.drawable.banana,R.drawable.plum,R.drawable.triangle,R.drawable.cylinder,R.drawable.hexagon,
            R.drawable.earth,R.drawable.saturn,R.drawable.nuptune,R.drawable.cucumber,R.drawable.turnip,R.drawable.brinjal,
            R.drawable.lion,R.drawable.kingfisher,R.drawable.canna,R.drawable.prism,R.drawable.mercury,R.drawable.peas};
    String answer[]={"FROG","GIRAFFE","ZEBRA","PENGUIN","SPARROW","KIWIS","RED","PINK","GREEN","HIBISCUS",
            "LILY","ORCHID","ORANGE","BANANA","PLUM","TRIANGLE","CYLINDER","HEXAGON","EARTH","SATURN","NEPTUNE","CUCUMBER",
            "TURNIP","BRINJAL","LION","KINGFISHER","CANNA","PRISM","MERCURY","PEAS"};
    int pageNumber=0,marks=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_papers);
    }
    public void addOne(View view)
    {
        TextView m = (TextView)findViewById(R.id.marks);
        TextView t1 = (TextView)findViewById(R.id.question);
        ImageView i1 = (ImageView)findViewById(R.id.question_image);
        EditText e1 = (EditText)findViewById(R.id.answer);
        Button b = (Button)findViewById(R.id.submit);
        String string =e1.getText().toString().trim();
        pageNumber++;
        if(pageNumber<30){
            m.setVisibility(View.INVISIBLE);
            if(string.equals(answer[pageNumber-1]))
            {
                marks++;
            }
            e1.setText("");
            t1.setText(question[pageNumber]);
            i1.setImageResource(image[pageNumber]);
        }
        else if(pageNumber==30)
        {
            if(string.equals(answer[pageNumber-1]))
            {
                marks++;
            }
            t1.setText("SCORE OUT OF 30 is:");
            i1.setVisibility(View.INVISIBLE);
            e1.setVisibility(View.INVISIBLE);
            b.setText("OK");
            m.setVisibility(View.VISIBLE);
            m.setText(String.valueOf(marks));
        }
        else
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}