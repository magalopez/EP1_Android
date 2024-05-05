package com.example.ep1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Producto extends AppCompatActivity {
    private EditText editTextCodigo, editTextNombre, editTextMarca, editTextPrecio;
    private Button btnAgregarProducto;
    private ListView listViewProductos;
    private ArrayList<String> listaProductos;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextMarca = findViewById(R.id.editTextMarca);
        editTextPrecio = findViewById(R.id.editTextPrecio);
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);
        listViewProductos = findViewById(R.id.listViewProductos);

        listaProductos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProductos);
        listViewProductos.setAdapter(adapter);

        btnAgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            agregarProducto();
            }
        });

    }

    private void agregarProducto() {
        String codigo = editTextCodigo.getText().toString().trim();
        String nombre = editTextNombre.getText().toString().trim();
        String marca = editTextMarca.getText().toString().trim();
        String precio = editTextPrecio.getText().toString().trim();

        String producto = "Código: " + codigo + "\nNombre: " + nombre + "\nMarca: " + marca + "\nPrecio: " + precio;
        listaProductos.add(producto);
        adapter.notifyDataSetChanged();

        limpiarCampos();
    }

    private void limpiarCampos() {
        editTextCodigo.getText().clear();
        editTextNombre.getText().clear();
        editTextMarca.getText().clear();
        editTextPrecio.getText().clear();
    }
}