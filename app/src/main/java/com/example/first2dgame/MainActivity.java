package com.example.first2dgame;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private boolean isMute= false;
    private ImageView volumeControl;

    @Override @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volumeControl = findViewById(R.id.volume_control);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.play).setOnClickListener(v -> startActivity(new Intent(getBaseContext(), GameActivity.class)));

        findViewById(R.id.instructions).setOnClickListener(v -> startActivity(new Intent(getBaseContext(), InstructionsActivity.class)));

        TextView highScore = findViewById(R.id.high_score);
        SharedPreferences sharedPreferences = getSharedPreferences("2D game", MODE_PRIVATE);
        highScore.setText("High Score : " + sharedPreferences.getInt("highScore", 0));

        changeSign();

        volumeControl.setOnClickListener(v -> {
            isMute = !isMute;
            changeSign();
            sharedPreferences.edit().putBoolean("isMute", isMute).apply();
        });
    }

    private void changeSign(){

        if (isMute){
            volumeControl.setImageResource(R.drawable.ic_volume_off_24);
        }else{
            volumeControl.setImageResource(R.drawable.ic_volume_up_24);
        }
    }
}