package com.example.inicio;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    Button backButton;  // Botón para volver atrás

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Obtener referencias de los elementos de la vista
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            loginButton = findViewById(R.id.loginButton);
            backButton = findViewById(R.id.btnBack);  // Referencia del botón "Volver Atrás"

            // Acción para el botón de inicio de sesión
            loginButton.setOnClickListener(v1 -> {
                if (username.getText().toString().equals("Macv") && password.getText().toString().equals("123")){
                    Toast.makeText(Login.this, "Ingreso exitoso", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(Login.this, MainMenuActivity.class);
                    startActivity(i2);
                } else {
                    Toast.makeText(Login.this, "Ingreso Denegado", Toast.LENGTH_SHORT).show();
                }
            });

            // Acción para el botón "Volver Atrás"
            backButton.setOnClickListener(v1 -> {
                finish();  // Cierra la actividad actual y vuelve atrás
            });

            return insets;
        });
    }
}
