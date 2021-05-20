package com.ngocdh.facebookimagepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

public class FacebookImagePickerActivity extends AppCompatActivity {

    private ImageButton btnClose;
    private List<Album> albums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_image_picker);
        this.mapping();
        this.loadData();
        this.btnClose.setOnClickListener(v -> FacebookImagePickerActivity.this.finish());
    }

    private void loadData() {
        this.albums = Gallery.getAlbums(Gallery.AssetType.ASSET_TYPE_PHOTOS, this);
    }

    private void mapping() {
        this.btnClose = this.findViewById(R.id.btnClose);
    }
}