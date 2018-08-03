package com.maurosarti.checkrootdevicetest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maurosarti.checkrootdevicetest.RootBeer.RootBeer;

public class MainActivity extends AppCompatActivity {

    private RootBeer rootBeer;
    private TextView text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootBeer = new RootBeer(this);
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RootUtils.isDeviceRooted() || rootBeer.isRooted()) {
                    text.setText("Esta rooteado!");
                    text.setTextColor(Color.RED);
                } else {
                    text.setText("Nada que ver, cero root!!");
                    text.setTextColor(Color.rgb(26, 145, 11));
                }
            }
        });
    }

}
