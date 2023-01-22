package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class NewAnimal extends AppCompatActivity {
    ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);
        String URL = "https://media.licdn.com/dms/image/C4D03AQEEfIpJp8JjQg/profile-displayphoto-shrink_800_800/0/1644271955756?e=2147483647&v=beta&t=R8Utuk9j_0yyI1ek2u1xJiw52uIjHdkAFWxGhUBH3LM";
        picture = findViewById(R.id.imageView1);
        new ImageLoadTask(URL, picture).execute();
    }
}