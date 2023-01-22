package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class BlenderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText an1;
    private EditText an2;
    private ImageView picture;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                TextView result = findViewById(R.id.resultView);
                result.setText(an1.getText().toString() + " + " + an2.getText().toString() + "= ESLAMI!!");
                picture.setVisibility(View.VISIBLE);
                break;
            default:
                Toast.makeText(this, "You Died", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blender);
        an1 = findViewById(R.id.animal1); // First animal view
        an2 = findViewById(R.id.animal2); // Second animal view
        Button mixButton = findViewById(R.id.btn1);
        mixButton.setOnClickListener(this);
        String URL = "https://media.licdn.com/dms/image/C4D03AQEEfIpJp8JjQg/profile-displayphoto-shrink_800_800/0/1644271955756?e=2147483647&v=beta&t=R8Utuk9j_0yyI1ek2u1xJiw52uIjHdkAFWxGhUBH3LM";
        picture = findViewById(R.id.imageView1);
        new ImageLoadTask(URL, picture).execute();
    }
}