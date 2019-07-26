package com.example.takeimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class GalleryPhoto extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ImageAdapter myImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_photo);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        myImageAdapter = new ImageAdapter(this);
        gridView.setAdapter(myImageAdapter);
        gridView.setOnItemClickListener(this);

        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetpath = ExternalStorageDirectoryPath + "/Gambar";
        Toast.makeText(getApplicationContext(),targetpath, Toast.LENGTH_SHORT).show();
        File targetDirector = new File(targetpath);
        File[]files = targetDirector.listFiles();
        for (File file : files){
            myImageAdapter.add(file.getAbsolutePath());
        }

    }
    @Override
    public  void  onClick(View v){

    }
    @Override
    public void  onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(GalleryPhoto.this, "Gambar Dipilih" + position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, SinglePhoto.class);
        i.putExtra("Path", myImageAdapter.itemList.get(position));
        startActivity(i);
    }
}
