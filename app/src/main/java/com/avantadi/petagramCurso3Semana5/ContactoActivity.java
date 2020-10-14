package com.avantadi.petagramCurso3Semana5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.avantadi.petagramCurso3Semana5.pojo.GMailSender;
import com.google.android.material.snackbar.Snackbar;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        //Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarContacto);
        setSupportActionBar(miActionBar);

        //activandpo la navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Button send = (Button) this.findViewById(R.id.btContactoEnviarComentario);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText etContactoMensaje = (EditText) findViewById(R.id.etContactoMensaje);
                EditText etContactoEmail = (EditText) findViewById(R.id.etContactoEmail);
                EditText etContactoNombre = (EditText) findViewById(R.id.etContactoNombre);
                try {
                    GMailSender sender = new GMailSender("username@gmail.com", "password");
                    sender.sendMail(getResources().getString(R.string.contacto_subject_email) + " " + etContactoNombre.getText().toString(),
                            etContactoMensaje.getText().toString(),
                            etContactoEmail.getText().toString(),
                            "user@yahoo.com");
                    //se notfica que el mensaje se ha enviado
                    Snackbar.make(getCurrentFocus(), R.string.contacto_mensaje_ok_email,Snackbar.LENGTH_SHORT).show();
                    //se borran los campos editables
                    etContactoNombre.setText("");
                    etContactoEmail.setText("");
                    etContactoMensaje.setText("");

                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                    Snackbar.make(getCurrentFocus(), R.string.contacto_mensaje_error_email,Snackbar.LENGTH_SHORT).show();
                }

            }
        });

    }

    //menu opciones ---------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_simplificado, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mybutton:
                // intent SegundaActividad
                Intent intento3 = new Intent(this, com.avantadi.petagramCurso3Semana5.SegundaActividad.class);
                startActivity(intento3);

        }

        return super.onOptionsItemSelected(item);
    }

}