package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    public ImageView logo;
    public TextView appTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        logo = (ImageView) findViewById(R.id.logoRegister);
        appTitle = (TextView) findViewById(R.id.appTitleRegister);

        logo.setColorFilter(getResources().getColor(android.R.color.primary_text_light), PorterDuff.Mode.SRC_IN);
        appTitle.setTextColor(getResources().getColor(android.R.color.primary_text_light));

    }
}