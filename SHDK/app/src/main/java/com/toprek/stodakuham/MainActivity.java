package com.toprek.stodakuham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    Button zapocni;

    public void OtvoriActivityIzbornik()
    {
        Intent intent = new Intent(this, Izbornik.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        zapocni = (Button) findViewById(R.id.ZapocniButton);
        zapocni.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {OtvoriActivityIzbornik();}
        });
    }
}