package com.example.inicio;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.inicio.R;

public class DevicesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices); // Asegúrate de tener este layout creado
    }

    // Método para manejar las acciones relacionadas con los dispositivos
    public void onDeviceAction(View view) {
        // Aquí puedes agregar la lógica de lo que debe hacer cuando se interactúa con los dispositivos
        Toast.makeText(this, "Acción sobre Dispositivo", Toast.LENGTH_SHORT).show();
    }
}
