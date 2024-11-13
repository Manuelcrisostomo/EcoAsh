// WaterLevel.java
package com.example.inicio;

public class WaterLevel {
    private String nivel;
    private String estado;

    public WaterLevel(String nivel, String estado) {
        this.nivel = nivel;
        this.estado = estado;
    }

    public String getNivel() {
        return nivel;
    }

    public String getEstado() {
        return estado;
    }
}
