package com.example.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class Usuarios extends AppCompatActivity {

    ListView listaUsuarios;
    List<Usuario> usuarios;
    ArrayAdapter<Usuario> adaptadorUsuarios;
    EditText editComuna, editCalle, editSector, editDispositivo;
    Button btnAgregarUsuario, btnActualizarUsuario, btnEliminarUsuario, btnRegistrarUsuario, btnVolverAtras;
    int usuarioSeleccionado = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        // Referencias a los elementos de la interfaz
        listaUsuarios = findViewById(R.id.listaUsuarios);
        editComuna = findViewById(R.id.editComuna);
        editCalle = findViewById(R.id.editCalle);
        editSector = findViewById(R.id.editSector);
        editDispositivo = findViewById(R.id.editDispositivo);
        btnAgregarUsuario = findViewById(R.id.btnAgregarUsuario);
        btnActualizarUsuario = findViewById(R.id.btnActualizarUsuario);
        btnEliminarUsuario = findViewById(R.id.btnEliminarUsuario);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
        btnVolverAtras = findViewById(R.id.btnVolver);  // Nueva referencia para el botón de volver

        usuarios = new ArrayList<>();

        // Cargar datos iniciales
        cargarDatosIniciales();
        actualizarListaUsuarios();

        // Acción para agregar usuario
        btnAgregarUsuario.setOnClickListener(v -> agregarUsuario());

        // Acción para actualizar usuario seleccionado
        btnActualizarUsuario.setOnClickListener(v -> actualizarUsuario());

        // Acción para eliminar usuario seleccionado
        btnEliminarUsuario.setOnClickListener(v -> eliminarUsuario());

        // Selección de un usuario para editar
        listaUsuarios.setOnItemClickListener((parent, view, position, id) -> seleccionarUsuario(position));

        // Acción para navegar a la pantalla de registro de usuario
        btnRegistrarUsuario.setOnClickListener(v -> navegarARegistroUsuario());

        // Acción para volver atrás
        btnVolverAtras.setOnClickListener(v -> volverAtras());
    }

    private void cargarDatosIniciales() {
        usuarios.add(new Usuario("Santiago", "Avenida Libertador", "Centro", "Dispositivo1"));
        usuarios.add(new Usuario("Valparaíso", "Calle 5", "Puerto", "Dispositivo2"));
        usuarios.add(new Usuario("Concepción", "Calle 10", "Sur", "Dispositivo3"));
    }

    private void agregarUsuario() {
        String comuna = editComuna.getText().toString();
        String calle = editCalle.getText().toString();
        String sector = editSector.getText().toString();
        String dispositivo = editDispositivo.getText().toString();

        if (!comuna.isEmpty() && !calle.isEmpty() && !sector.isEmpty() && !dispositivo.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(comuna, calle, sector, dispositivo);
            usuarios.add(nuevoUsuario);
            actualizarListaUsuarios();
            limpiarCampos();
            Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarUsuario() {
        if (usuarioSeleccionado != -1) {
            String comuna = editComuna.getText().toString();
            String calle = editCalle.getText().toString();
            String sector = editSector.getText().toString();
            String dispositivo = editDispositivo.getText().toString();

            if (!comuna.isEmpty() && !calle.isEmpty() && !sector.isEmpty() && !dispositivo.isEmpty()) {
                Usuario usuario = usuarios.get(usuarioSeleccionado);
                usuario.setComuna(comuna);
                usuario.setCalle(calle);
                usuario.setSector(sector);
                usuario.setDispositivo(dispositivo);
                actualizarListaUsuarios();
                limpiarCampos();
                usuarioSeleccionado = -1;
                Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Seleccione un usuario para actualizar", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarUsuario() {
        if (usuarioSeleccionado != -1) {
            usuarios.remove(usuarioSeleccionado);
            actualizarListaUsuarios();
            limpiarCampos();
            usuarioSeleccionado = -1;
            Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Seleccione un usuario para eliminar", Toast.LENGTH_SHORT).show();
        }
    }

    private void seleccionarUsuario(int position) {
        usuarioSeleccionado = position;
        Usuario usuario = usuarios.get(position);
        editComuna.setText(usuario.getComuna());
        editCalle.setText(usuario.getCalle());
        editSector.setText(usuario.getSector());
        editDispositivo.setText(usuario.getDispositivo());
    }

    private void actualizarListaUsuarios() {
        adaptadorUsuarios = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        listaUsuarios.setAdapter(adaptadorUsuarios);
    }

    private void limpiarCampos() {
        editComuna.setText("");
        editCalle.setText("");
        editSector.setText("");
        editDispositivo.setText("");
    }

    private void navegarARegistroUsuario() {
        Intent intent = new Intent(Usuarios.this, RegistroActivity.class);
        startActivity(intent);
    }

    private void volverAtras() {
        finish();
    }
}
