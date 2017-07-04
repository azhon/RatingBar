package com.azhong.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azhong.ratingbar.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        final Button button = (Button) findViewById(R.id.btn);
        final Button buttonSet = (Button) findViewById(R.id.btn_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(String.valueOf(ratingBar.getStar()));
            }
        });
        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setStar(0);
                buttonSet.setText(String.valueOf(ratingBar.getStar()));
            }
        });

    }
}
