package com.themap.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Quitar actionBar
        Objects.requireNonNull(this.getSupportActionBar()).hide();
    }

    // Para cuadnoa se presione el botón, cambiar la imagen 1 por 2 y
    // viceversa.
    public void onClickButton(View view){
        ImageView imageViewFondo = this.findViewById(R.id.imageViewFondo);
        //String strImageTag = imageViewFondo.getTag().toString();

        //Escribir el código para que cargue una imagen aleatoria entre 1 y 4
        //Paso 1. Generar un número aleatorio entre 1 y 4
        //Paso 2. Asignar esa imagen al ImageView
        Random numero = new Random();
        int numeroRandom = numero.nextInt(4) + 1;
        if (numeroRandom==1)
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img1));
        else if (numeroRandom==2)
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img2));
        else if (numeroRandom==3)
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img3));
        else if (numeroRandom==4)
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img4));

        Toast.makeText(this, "Numero Random: "+String.valueOf(numeroRandom), Toast.LENGTH_SHORT).show();
        /*if(strImageTag.compareTo("img1")==0){
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img2));
            imageViewFondo.setTag("img2");
        } else {
            imageViewFondo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.img1));
            imageViewFondo.setTag("img1");
        }*/
    }
    
    //Lo visto en clase
    public Drawable getImageByString (String strNombreImagen){
        int intImagenID = getResources().getIdentifier(strNombreImagen, "drawable", getPackageName());
        return ResourcesCompat.getDrawable(getResources(), intImagenID, null);
    }
}