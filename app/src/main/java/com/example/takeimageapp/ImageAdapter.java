package com.example.takeimageapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<String> itemList = new ArrayList<>();

    public ImageAdapter(Context c) { mContext = c; }

    void add(String path) { itemList.add(path); }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }else {
            imageView = (ImageView) convertView;
        }
        Bitmap bitmap = decodeSampledBitmapFromUri(itemList.get(position),200,200);
        imageView.setImageBitmap(bitmap);
        return imageView;
}
public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight){

   Bitmap bm = null;
   final BitmapFactory.Options options = new BitmapFactory.Options();
   options.inJustDecodeBounds = true;
   BitmapFactory.decodeFile(path, options);

   options.inSampleSize = calculateSampleSize(options, reqWidth, reqHeight);

   options.inJustDecodeBounds = false;
   bm = BitmapFactory.decodeFile(path, options);

   return  bm;
}
public int calculateSampleSize(BitmapFactory.Options options, int reqWidht, int reqHeight) {

    final int height = options.outHeight;
    final int widht = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || widht > reqWidht) {
        if (widht > height) {
            inSampleSize = Math.round((float) height / (float) reqHeight);
        } else {
            inSampleSize = Math.round((float) widht / (float) reqWidht);
        }
    }
    return inSampleSize;
}
}

