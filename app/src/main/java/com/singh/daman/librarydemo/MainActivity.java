package com.singh.daman.librarydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.singh.daman.mybutton.ShapedButton;

public class MainActivity extends AppCompatActivity {
    Toast message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShapedButton star=(ShapedButton)findViewById(R.id.star);
        ShapedButton rectangle=(ShapedButton)findViewById(R.id.rectangle);
        ShapedButton round=(ShapedButton)findViewById(R.id.round);
        ShapedButton circle=(ShapedButton)findViewById(R.id.circle);

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=Toast.makeText(getBaseContext(),"Star button is clicked",Toast.LENGTH_SHORT);
                message.show();
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=Toast.makeText(getBaseContext(),"Rectangle button is clicked",Toast.LENGTH_SHORT);
                message.show();
            }
        });

        round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=Toast.makeText(getBaseContext(),"Round Rectangle button is clicked",Toast.LENGTH_SHORT);
                message.show();
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message=Toast.makeText(getBaseContext(),"Circular button is clicked",Toast.LENGTH_SHORT);
                message.show();
            }
        });
    }
}
