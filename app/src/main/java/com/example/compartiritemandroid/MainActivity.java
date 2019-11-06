package com.example.compartiritemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Creamos el boton compartir
    private Button botonCompartir;
    private TextView texto;
    private String NombreEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton compartir
        texto = findViewById(R.id.textView);
        NombreEvento= texto.getText().toString();
        botonCompartir = findViewById(R.id.compartir);
        botonCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = NombreEvento;
                String shareSub = "Compartido desde mi dispositivo Android";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Compartir con..."));

            }
        });

    }

}
