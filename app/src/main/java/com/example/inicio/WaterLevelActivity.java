// WaterLevelActivity.java
package com.example.inicio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WaterLevelActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WaterLevelAdapter waterLevelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_level);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear una lista de niveles de agua
        ArrayList<WaterLevel> waterLevels = new ArrayList<>();
        waterLevels.add(new WaterLevel("10 cm", "Bajo"));
        waterLevels.add(new WaterLevel("50 cm", "Normal"));
        waterLevels.add(new WaterLevel("90 cm", "Alto"));
        // Agrega más niveles según sea necesario

        // Instanciar el adaptador y establecerlo en el RecyclerView
        waterLevelAdapter = new WaterLevelAdapter(waterLevels);
        recyclerView.setAdapter(waterLevelAdapter);
    }
}
