package com.example.inicio;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button iniciarSesion;
    Button Registrarse;
    Button btnSalir;  // Botón de salir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configurar las vistas después de que el layout se haya cargado
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Inicialización de los botones
            iniciarSesion = findViewById(R.id.iniciarSesion);
            Registrarse = findViewById(R.id.Registrarse);
            btnSalir = findViewById(R.id.btnSalir);  // Inicializar el botón de salir

            // Configurar el botón de iniciar sesión
            iniciarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    startActivity(i);
                }
            });

            // Configurar el botón de registrarse
            Registrarse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, RegistroActivity.class);
                    startActivity(i);
                }
            });

            // Configurar el botón de salir
            btnSalir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishAffinity(); // Cierra todas las actividades y cierra la app
                }
            });


            return insets;
        });
    }
}
