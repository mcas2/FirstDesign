package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    public ImageView logo;
    public TextView appTitle;

    public Button backToLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        backToLoginButton = (Button) findViewById(R.id.backToLoginButton);

        backToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        logo = (ImageView) findViewById(R.id.logoRegister);
        appTitle = (TextView) findViewById(R.id.appTitleRegister);

        logo.setColorFilter(getResources().getColor(android.R.color.primary_text_light), PorterDuff.Mode.SRC_IN);
        appTitle.setTextColor(getResources().getColor(android.R.color.primary_text_light));

    }
}