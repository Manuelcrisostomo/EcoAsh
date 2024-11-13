package com.example.inicio;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class UsersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users); // Asegúrate de tener este layout creado
    }

    // Método para manejar las acciones relacionadas con los usuarios
    public void onUserAction(View view) {
        // Aquí puedes agregar la lógica de lo que debe hacer cuando se interactúa con los usuarios
        Toast.makeText(this, "Acción sobre Usuario", Toast.LENGTH_SHORT).show();
    }
}
