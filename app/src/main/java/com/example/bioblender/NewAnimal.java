package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewAnimal extends AppCompatActivity {
    ImageView picture;
    private String name;
    private String description;
    private String URL;
    private String reason;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_animal);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        description = i.getStringExtra("description");
        URL = i.getStringExtra("URL");
        System.out.println("Java URL check: " + URL);
        reason = i.getStringExtra("reason");
        picture = findViewById(R.id.imageView1);
        new ImageLoadTask(URL, picture).execute();
        TextView animal = findViewById(R.id.animal_name);
        animal.setText(name);
    }
}