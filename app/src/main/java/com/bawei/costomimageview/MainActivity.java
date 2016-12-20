package com.bawei.costomimageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    RoundImage cos_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cos_main = (RoundImage)findViewById(R.id.cos_main);

        //drawable 图片变成bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.welcome_2);
        cos_main.setImageBitmap(bitmap);
    }
}
