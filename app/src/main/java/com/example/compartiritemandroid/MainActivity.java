package com.example.compartiritemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Creamos el boton compartir
    private Button botonCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton compartir
        botonCompartir = findViewById(R.id.compartir);
        botonCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Texto...";
                String shareSub = "Compartido desde mi dispositivo Android";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                //myIntent.setPackage("com.facebook.katana");
                //myIntent.setPackage("com.whatsapp");
                //myIntent.setPackage("com.twitter.android");

                startActivity(Intent.createChooser(myIntent, "Compartir con..."));

            }
        });

    }

}
