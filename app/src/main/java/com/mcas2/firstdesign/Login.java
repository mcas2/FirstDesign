package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    public TextView forgotPassword;
    public Button registerButton;
    public ImageView logo;
    public TextView appTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logo = (ImageView) findViewById(R.id.logo);
        appTitle = (TextView) findViewById(R.id.appTitle);
        logo.setColorFilter(getResources().getColor(android.R.color.primary_text_light), PorterDuff.Mode.SRC_IN);
        appTitle.setTextColor(getResources().getColor(android.R.color.primary_text_light));



        forgotPassword = (TextView) findViewById(R.id.forgotPasswordText);
        forgotPassword.setOnClickListener(view -> {
            View alertView = LayoutInflater.from(Login.this).inflate(R.layout.dialog_recover_email, null);
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Puedes recuperarla a través de tu correo electrónico.")
                    .setView(alertView)
                    .setPositiveButton("Nueva contraseña", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Login.this, "Mira tu correo y cambia la contraseña", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .setIcon(R.drawable.ic_warning)
                    .show();
        });

        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(view -> openRegister());
    }

    public void openMain(View view) {
        Toast toast = Toast.makeText(Login.this, "Entrar al Main", Toast.LENGTH_LONG);
        toast.show();
    }

    public void openRegister(){
        Pair[] pairs =  new Pair[2];
        pairs[0] = new Pair<View, String>(logo, "logoPair");
        pairs[1] = new Pair<View, String>(appTitle, "appTitlePair");
        Intent intent = new Intent(Login.this, Register.class);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }
}