package com.example.inicio;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    EditText editNombre, editCorreo, editContraseña, editConfirmarContraseña;
    Button btnRegistrar, btnVolver;
    TextView textLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Referencias a los elementos de la interfaz
        editNombre = findViewById(R.id.editNombre);
        editCorreo = findViewById(R.id.editCorreo);
        editContraseña = findViewById(R.id.editContraseña);
        editConfirmarContraseña = findViewById(R.id.editConfirmarContraseña);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolver = findViewById(R.id.btnVolver);
        textLogin = findViewById(R.id.textLogin);

        // Evento del botón "Registrarse"
        btnRegistrar.setOnClickListener(v -> registrarUsuario());

        // Evento para ir a la pantalla de inicio de sesión
        textLogin.setOnClickListener(v -> navegarAInicioSesion());

        // Evento para el botón "Volver Atrás"
        btnVolver.setOnClickListener(v -> navegarAInicioSesion());
    }

    private void registrarUsuario() {
        String nombre = editNombre.getText().toString();
        String correo = editCorreo.getText().toString();
        String contraseña = editContraseña.getText().toString();
        String confirmarContraseña = editConfirmarContraseña.getText().toString();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || confirmarContraseña.isEmpty()) {
            Toast.makeText(this, "Todos los campos deben ser completados", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar si las contraseñas coinciden
        if (!contraseña.equals(confirmarContraseña)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Guardar usuario en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nombre", nombre);  // Guardamos el nombre
        editor.putString("correo", correo);  // Guardamos el correo
        editor.putString("contraseña", contraseña);  // Guardamos la contraseña
        boolean isSaved = editor.commit();  // Usamos commit() para verificar si se guardó

        // Verificar si se guardó exitosamente
        if (isSaved) {
            Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
        }

        // Limpiar los campos después del registro
        limpiarCampos();
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editCorreo.setText("");
        editContraseña.setText("");
        editConfirmarContraseña.setText("");
    }

    // Método para navegar a la actividad de inicio de sesión
    public void navegarAInicioSesion() {
        finish();  // Cierra la actividad actual y regresa a la actividad de inicio de sesión
    }
}
