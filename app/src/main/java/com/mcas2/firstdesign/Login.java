package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public TextView forgotPassword;
    //final EditText taskEditText = new EditText(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View alertView = LayoutInflater.from(Login.this).inflate(R.layout.alert_email, null);
        forgotPassword = (TextView) findViewById(R.id.forgotPasswordText);
        forgotPassword.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Puedes recuperarla a través de tu correo electrónico.")
                    .setView(alertView)
                    .setPositiveButton("Nueva contraseña", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Login.this, "Mira tu correo y cambia la contraseña", Toast.LENGTH_SHORT).show();
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton("Cancelar", null)
                    .setIcon(R.drawable.ic_warning)
                    .show();
        });
    }

    public void openMain(View view) {
        Toast toast = Toast.makeText(Login.this, "Entrar al Main", Toast.LENGTH_LONG);
        toast.show();
    }
}