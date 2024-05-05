package com.example.ep1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Salarios extends AppCompatActivity {
    Spinner spinnerCargos;
    String[] cargos = {
            "Selecciona un cargo",
            "Administrador",
            "Contador",
            "Vendedor",
            "Recepcionista",
            "Programador"
    };
    ArrayAdapter<String> adapter;

    RadioGroup radioGroupAdminFondos;
    RadioButton radioFondoAfp;
    RadioButton radioFondoOnp;

    TextView txtSueldoNeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_salarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerCargos = findViewById(R.id.spinner_cargos);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cargos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCargos.setAdapter(adapter);

        radioGroupAdminFondos = findViewById(R.id.admin_fondos);
        radioFondoAfp = findViewById(R.id.fondos_afp);
        radioFondoOnp = findViewById(R.id.fondos_onp);

        txtSueldoNeto = findViewById(R.id.txt_sueldo);
    }

    public void Clean (View v) {
        spinnerCargos.setSelection(0);
        radioGroupAdminFondos.check(R.id.fondos_afp);
        txtSueldoNeto.setText("");
    }

    public void Calc (View v) {
        int sueldo;
        int descuento;

        String cargoSeleccionado = spinnerCargos.getSelectedItem().toString();

        switch (cargoSeleccionado) {
            case "Administrador":
                sueldo = 5000;
                break;
            case "Contador":
                sueldo = 3500;
                break;
            case "Vendedor":
                sueldo = 2000;
                break;
            case "Recepcionista":
                sueldo = 1500;
                break;
            case "Programador":
                sueldo = 4000;
                break;
            default:
                sueldo = 0;
        }

        if (radioFondoAfp.isChecked()) {
            descuento = 10;
        } else if (radioFondoOnp.isChecked()) {
            descuento = 13;
        }
        else {
            descuento = 0;
        }

        double sueldoNeto = sueldo - (sueldo * descuento / 100.0);

        String resultado;
        if(sueldo == 0) {
            resultado = "Selecciona un cargo";
        }
        else {
            resultado = "Sueldo Neto: " + (String.valueOf(sueldoNeto));
        }
        txtSueldoNeto.setText(resultado);
    }
}