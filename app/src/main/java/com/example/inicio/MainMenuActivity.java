package com.example.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu); // Asegúrate de tener este layout creado.

        // Habilita el botón de retroceso en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button btnUsers = findViewById(R.id.btnUsers);
        Button btnDevices = findViewById(R.id.btnDevices);
        Button btnBack = findViewById(R.id.btnBack); // Botón para retroceder en el layout

        // Configura la acción para el botón "Usuarios"
        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, Usuarios.class);
                startActivity(intent);
            }
        });

        // Configura la acción para el botón "Dispositivos"
        btnDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, Dispositivos.class);
                startActivity(intent);
            }
        });

        // Configura la acción para el botón "Atrás" en el layout
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y regresa a la anterior
            }
        });
    }

    // Sobrescribe onOptionsItemSelected para manejar la acción de retroceso en la ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Cierra la actividad actual y regresa a la anterior
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
