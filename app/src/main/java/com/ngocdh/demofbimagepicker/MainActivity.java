package com.ngocdh.demofbimagepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ngocdh.facebookimagepicker.Album;
import com.ngocdh.facebookimagepicker.FacebookImagePickerActivity;
import com.ngocdh.facebookimagepicker.Gallery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[NGOCDH]-" + MainActivity.class.getSimpleName();
    private Button btnImagePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mapping();
        this.btnImagePicker.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FacebookImagePickerActivity.class);
            MainActivity.this.startActivity(intent);
        });
    }

    private void mapping() {
        this.btnImagePicker = findViewById(R.id.btnPickImage);
    }
}