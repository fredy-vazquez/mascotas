package com.frvazquez.mascotas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.frvazquez.mascotas.R;

public class Contacto extends AppCompatActivity {

    private EditText etEmail;
    private EditText etNombreCompleto;
    private EditText etMensaje;
    private Button btnEnviarComentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        iniciarlizarView();
        send();
    }

    private void iniciarlizarView() {
        etEmail =  findViewById( R.id.etEmail );
        etNombreCompleto =  findViewById( R.id.etNombre );
        etMensaje =  findViewById( R.id.etComentario );
        btnEnviarComentario =  findViewById( R.id.btnEnviarComentario );
    }

    private void send() {
        btnEnviarComentario.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String nombre = etNombreCompleto.getText().toString();
                String mensaje = etMensaje.getText().toString();
                Toast.makeText( getBaseContext(), "Mensaje Enviado", Toast.LENGTH_LONG ).show();

                Intent sendIntent = new Intent( (Intent.ACTION_SEND) );
                sendIntent.setType( "plain/text" );
                sendIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{email} );
                sendIntent.putExtra( Intent.EXTRA_TEXT, mensaje );
                sendIntent.putExtra( Intent.EXTRA_SUBJECT, "Enviado por: " + nombre );
                startActivity(Intent.createChooser( sendIntent, "... ") );
            }
        } );
    }
}