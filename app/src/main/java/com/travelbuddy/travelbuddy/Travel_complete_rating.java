package com.travelbuddy.travelbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Travel_complete_rating extends AppCompatActivity {

    private TextView SkipFeedback;
    private Button feedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_complete_rating);

        SkipFeedback = (TextView) findViewById(R.id.skip);

        SkipFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Travel_complete_rating.this, NavActivity.class));
            }
        });

        feedBack = (Button) findViewById(R.id.FeedBack);
        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Travel_complete_rating.this, "Feedback Has Been Sent!.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
