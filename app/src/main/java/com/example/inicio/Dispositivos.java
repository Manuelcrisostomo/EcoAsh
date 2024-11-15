package com.example.inicio;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.Button;



import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Dispositivos extends AppCompatActivity {

    private ListView listViewDispositivos;
    private EditText etComuna, etCalle, etSector, etDispositivo;
    private EditText etPM25, etPM10, etCO2, etCO, etMonoxidoCarbono, etTemperatura, etHumedad, etNivelCenizas;
    private EditText etUVRadiacion, etVelocidadViento, etClima;
    private Button btnAdd, btnUpdate, btnDelete,btnVolverAtras, btnBack;
    private ArrayList<SensorData> sensores;
    private ArrayAdapter<SensorData> adapter;
    private SensorData selectedSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivos);

        // Inicializar vistas
        listViewDispositivos = findViewById(R.id.listViewDispositivos);
        etComuna = findViewById(R.id.etComuna);
        etCalle = findViewById(R.id.etCalle);
        etSector = findViewById(R.id.etSector);
        etDispositivo = findViewById(R.id.etDispositivo);
        etPM25 = findViewById(R.id.etPM25);
        etPM10 = findViewById(R.id.etPM10);
        etCO2 = findViewById(R.id.etCO2);
        etCO = findViewById(R.id.etCO);
        etMonoxidoCarbono = findViewById(R.id.etMonoxidoCarbono);
        etTemperatura = findViewById(R.id.etTemperatura);
        etHumedad = findViewById(R.id.etHumedad);
        etNivelCenizas = findViewById(R.id.etNivelCenizas);
        etUVRadiacion = findViewById(R.id.etUVRadiacion);
        etVelocidadViento = findViewById(R.id.etVelocidadViento);
        etClima = findViewById(R.id.etClima);
        btnAdd = findViewById(R.id.btnAgregar);
        btnUpdate = findViewById(R.id.btnActualizar);
        btnDelete = findViewById(R.id.btnBorrar);
        btnBack = findViewById(R.id.btnBack);

        sensores = new ArrayList<>();
        cargarDatosPreCargados();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensores);
        listViewDispositivos.setAdapter(adapter);

        listViewDispositivos.setOnItemClickListener((parent, view, position, id) -> {
            selectedSensor = sensores.get(position);
            if (selectedSensor != null) {
                cargarCampos(selectedSensor);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });

        btnAdd.setOnClickListener(v -> {
            if (!isValidInput()) {
                Toast.makeText(this, "Por favor ingrese un dato válido en todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                SensorData newSensor = crearSensorDesdeCampos();
                sensores.add(newSensor);
                adapter.notifyDataSetChanged();
                clearFields();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Todos los campos deben ser números válidos", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(v -> {
            if (selectedSensor != null) {
                if (!isValidInput()) {
                    Toast.makeText(this, "Por favor ingrese un dato válido en todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                actualizarSensorDesdeCampos(selectedSensor);
                adapter.notifyDataSetChanged();
                clearFields();
            } else {
                Toast.makeText(this, "Selecciona un dispositivo para actualizar", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedSensor != null) {
                sensores.remove(selectedSensor);
                adapter.notifyDataSetChanged();
                clearFields();
            } else {
                Toast.makeText(this, "Selecciona un dispositivo para eliminar", Toast.LENGTH_SHORT).show();
            }
        });
        // Volver atrás
        btnBack.setOnClickListener(v -> {
            if (selectedSensor == null) {
                finish(); // Si no hay dispositivo seleccionado, salir
            } else {
                clearFields();
            }
        });



    }


    private void cargarCampos(SensorData sensor) {
        etComuna.setText(sensor.getComuna());
        etCalle.setText(sensor.getCalle());
        etSector.setText(sensor.getSector());
        etDispositivo.setText(sensor.getDispositivo());
        etPM25.setText(String.valueOf(sensor.getPm25()));
        etPM10.setText(String.valueOf(sensor.getPm10()));
        etCO2.setText(String.valueOf(sensor.getCo2()));
        etCO.setText(String.valueOf(sensor.getCo()));
        etMonoxidoCarbono.setText(String.valueOf(sensor.getMonoxidoCarbono()));
        etTemperatura.setText(String.valueOf(sensor.getTemperatura()));
        etHumedad.setText(String.valueOf(sensor.getHumedad()));
        etNivelCenizas.setText(String.valueOf(sensor.getNivelCenizas()));
        etUVRadiacion.setText(String.valueOf(sensor.getUVRadiacion()));
        etVelocidadViento.setText(String.valueOf(sensor.getVelocidadViento()));
        etClima.setText(sensor.getClima());
    }

    private SensorData crearSensorDesdeCampos() {
        return new SensorData(
                etComuna.getText().toString(),
                etCalle.getText().toString(),
                etSector.getText().toString(),
                etDispositivo.getText().toString(),
                parseDouble(etPM25),
                parseDouble(etPM10),
                parseDouble(etCO2),
                parseDouble(etCO),
                parseDouble(etMonoxidoCarbono),
                parseDouble(etTemperatura),
                parseDouble(etHumedad),
                parseDouble(etNivelCenizas),
                parseDouble(etUVRadiacion),
                parseDouble(etVelocidadViento),
                etClima.getText().toString()
        );
    }

    private void actualizarSensorDesdeCampos(SensorData sensor) {
        sensor.setComuna(etComuna.getText().toString());
        sensor.setCalle(etCalle.getText().toString());
        sensor.setSector(etSector.getText().toString());
        sensor.setDispositivo(etDispositivo.getText().toString());
        sensor.setPm25(parseDouble(etPM25));
        sensor.setPm10(parseDouble(etPM10));
        sensor.setCo2(parseDouble(etCO2));
        sensor.setCo(parseDouble(etCO));
        sensor.setMonoxidoCarbono(parseDouble(etMonoxidoCarbono));
        sensor.setTemperatura(parseDouble(etTemperatura));
        sensor.setHumedad(parseDouble(etHumedad));
        sensor.setNivelCenizas(parseDouble(etNivelCenizas));
        sensor.setUVRadiacion(parseDouble(etUVRadiacion));
        sensor.setVelocidadViento(parseDouble(etVelocidadViento));
        sensor.setClima(etClima.getText().toString());
    }

    private double parseDouble(EditText editText) {
        try {
            return Double.parseDouble(editText.getText().toString());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private void clearFields() {
        etComuna.setText("");
        etCalle.setText("");
        etSector.setText("");
        etDispositivo.setText("");
        etPM25.setText("");
        etPM10.setText("");
        etCO2.setText("");
        etCO.setText("");
        etMonoxidoCarbono.setText("");
        etTemperatura.setText("");
        etHumedad.setText("");
        etNivelCenizas.setText("");
        etUVRadiacion.setText("");
        etVelocidadViento.setText("");
        etClima.setText("");
        selectedSensor = null;
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    private boolean isValidInput() {
        return !etComuna.getText().toString().isEmpty() &&
                !etCalle.getText().toString().isEmpty() &&
                !etSector.getText().toString().isEmpty() &&
                !etDispositivo.getText().toString().isEmpty() &&
                !etPM25.getText().toString().isEmpty() &&
                !etPM10.getText().toString().isEmpty() &&
                !etCO2.getText().toString().isEmpty() &&
                !etCO.getText().toString().isEmpty() &&
                !etMonoxidoCarbono.getText().toString().isEmpty() &&
                !etTemperatura.getText().toString().isEmpty() &&
                !etHumedad.getText().toString().isEmpty() &&
                !etNivelCenizas.getText().toString().isEmpty() &&
                !etUVRadiacion.getText().toString().isEmpty() &&
                !etVelocidadViento.getText().toString().isEmpty();
    }

    private void cargarDatosPreCargados() {
        sensores.add(new SensorData("Santiago", "Calle Falsa", "Sector A", "Dispositivo 001", 30, 15, 400, 0.5, 2, 24, 50, 10, 8, 15, "Nublado"));
        sensores.add(new SensorData("Valparaíso", "Calle Real", "Sector B", "Dispositivo 002", 45, 20, 500, 0.7, 3, 22, 60, 15, 9, 20, "Despejado"));
    }
}






















// Clase Usuario


class Usuario {
    private String comuna;
    private String calle;
    private String sector;
    private String dispositivo;

    public Usuario(String comuna, String calle, String sector, String dispositivo) {
        this.comuna = comuna;
        this.calle = calle;
        this.sector = sector;
        this.dispositivo = dispositivo;
    }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getDispositivo() { return dispositivo; }
    public void setDispositivo(String dispositivo) { this.dispositivo = dispositivo; }

    @Override
    public String toString() {
        return "Ubicación: " + comuna + ", " + calle + ", " + sector + " - Dispositivo: " + dispositivo;
    }
}


// Clase Dispositivo
class Dispositivo {
    private String nombre;
    private List<Usuario> usuarios;
    private double nivelAgua;
    private double nivelPh;

    public Dispositivo(String nombre, double nivelAgua, double nivelPh) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
        this.nivelAgua = nivelAgua;
        this.nivelPh = nivelPh;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public double getNivelPh() {
        return nivelPh;
    }

    public void setNivelPh(double nivelPh) {
        this.nivelPh = nivelPh;
    }

    @Override
    public String toString() {
        return "Dispositivo: " + nombre + ", Nivel de agua: " + nivelAgua + ", Nivel de pH: " + nivelPh;
    }
}
