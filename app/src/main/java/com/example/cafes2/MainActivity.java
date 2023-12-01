package com.example.cafes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private Button agregar;
    private Spinner bebida;
    private RecyclerView recyclerView;
    private List<Producto> productoList;
    private ProductoAdapter productoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inicializar los demas objetos
        nombre = findViewById(R.id.tf_nombre);
        agregar = findViewById(R.id.btn_agregar);
        bebida = findViewById(R.id.cb_bebida);

        // inicializar recycleview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear lista de productos de cura
        productoList = new ArrayList<>();

        productoAdapter = new ProductoAdapter(productoList);
        recyclerView.setAdapter(productoAdapter);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString().trim();
                String p = bebida.getSelectedItem().toString().trim();
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(p)){
                    Toast.makeText(MainActivity.this,
                            "Todos los campos deben estar llenos",
                            Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println(n);
                    System.out.println(p);
                    Producto nuevoProducto = new Producto(n,p);
                    productoList.add(nuevoProducto);
                    //notificar al adapter que hay nuevos cambios
                    productoAdapter.notifyDataSetChanged();
                    //limpiar campos de entrada despues de agregar
                    nombre.setText("");
                    bebida.setSelection(0);
                }

            }
        });
    }
}