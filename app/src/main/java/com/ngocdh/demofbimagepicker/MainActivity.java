package com.ngocdh.demofbimagepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ngocdh.facebookimagepicker.FacebookImagePickerActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnImagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mapping();
        this.btnImagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FacebookImagePickerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    private void mapping() {
        this.btnImagePicker = findViewById(R.id.btnPickImage);
    }
}