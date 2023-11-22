package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    public Button loginButton;
    public ImageView logo;
    public TextView appTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logo = (ImageView) findViewById(R.id.logo);
        appTitle = (TextView) findViewById(R.id.appTitle);



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
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton.setOnClickListener(view -> openRegister());
        loginButton.setOnClickListener(view -> openMain());
    }

    public void openMain() {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
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