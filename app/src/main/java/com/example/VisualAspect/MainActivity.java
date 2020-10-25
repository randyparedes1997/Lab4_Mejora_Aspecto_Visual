package com.example.VisualAspect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button btnCancelar;

    private List<Persona> personas;
    private TypedArray imagen;
    private String[] deportistas;
    private String[] nacionalidad;
    private String[] descripcion;
    private String[] links;

    private void inicializarDatos(){
        personas = new ArrayList<>();
        imagen = getResources().obtainTypedArray(R.array.deportistas_img);
        nacionalidad=getResources().getStringArray(R.array.nacionalidad);
        deportistas = getResources().getStringArray(R.array.Deportistas);
        descripcion=getResources().getStringArray(R.array.descripcion);
        links=getResources().getStringArray(R.array.links);
        for (int i=0 ; i< imagen.length();i++){
            personas.add(new Persona( deportistas[i],"Pais de nacimiento: "+nacionalidad[i], imagen.getResourceId(i,-1) ,i,descripcion[i],links[i]));
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        inicializarDatos();

        RVAdapter rvAdapter = new RVAdapter(personas,getApplicationContext());
        recyclerView.setAdapter(rvAdapter);
    }
}