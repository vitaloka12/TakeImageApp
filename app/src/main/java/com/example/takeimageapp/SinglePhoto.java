package com.example.takeimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class SinglePhoto extends AppCompatActivity {
    ImageAdapter myImageAdapter;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_photo);

        String imgPath = this.getIntent().getExtras().getString("Path");
        ImageView iv = (ImageView) findViewById(R.id.singleimage);
        BitmapFactory.Options myBitmap = new BitmapFactory.Options();
        myBitmap.inJustDecodeBounds = false;
        myBitmap.inSampleSize = 4;
        myBitmap.inPurgeable = true;
        Bitmap bitmap = BitmapFactory.decodeFile(imgPath, myBitmap);
        iv.setImageBitmap(bitmap);
    }
}