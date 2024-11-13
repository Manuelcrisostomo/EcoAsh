package com.example.inicio;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class SensorData {

    private String comuna;
    private String calle;
    private String sector;
    private String dispositivo;
    private double pm25;
    private double pm10;
    private double co2;
    private double co;
    private double monoxidoCarbono;
    private double temperatura;
    private double humedad;
    private double nivelCenizas;

    // Constructor
    public SensorData(String comuna, String calle, String sector, String dispositivo,
                      double pm25, double pm10, double co2, double co, double monoxidoCarbono,
                      double temperatura, double humedad, double nivelCenizas) {
        this.comuna = comuna;
        this.calle = calle;
        this.sector = sector;
        this.dispositivo = dispositivo;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.co2 = co2;
        this.co = co;
        this.monoxidoCarbono = monoxidoCarbono;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.nivelCenizas = nivelCenizas;
    }

    // Métodos getters y setters
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getMonoxidoCarbono() {
        return monoxidoCarbono;
    }

    public void setMonoxidoCarbono(double monoxidoCarbono) {
        this.monoxidoCarbono = monoxidoCarbono;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public double getNivelCenizas() {
        return nivelCenizas;
    }

    public void setNivelCenizas(double nivelCenizas) {
        this.nivelCenizas = nivelCenizas;
    }

    // Método toString modificado para mostrar los niveles con colores utilizando SpannableString
    @Override
    public String toString() {
        SpannableString spannableString = new SpannableString(
                "Dispositivo: " + dispositivo +"Comuna: " + comuna +
                        "Calle: " + calle +
                        "Sector: " + sector +
                        "PM25: " + pm25 + " " + obtenerNivelConColor(pm25, 10, 20) + "\n" +
                        "PM10: " + pm10 + " " + obtenerNivelConColor(pm10, 15, 30) +
                        "CO2: " + co2 + " " + obtenerNivelConColor(co2, 300, 600) +
                        "CO: " + co + " " + obtenerNivelConColor(co, 0.1, 0.5) + "\n" +
                        "Monóxido de Carbono: " + monoxidoCarbono + " " + obtenerNivelConColor(monoxidoCarbono, 0.1, 0.5) +
                        "Temperatura: " + temperatura + "°C " + obtenerNivelTemperaturaConColor(temperatura) +
                        "Humedad: " + humedad + "% " + obtenerNivelConColor(humedad, 30, 70) + "\n" +
                        "Nivel de Cenizas: " + nivelCenizas + " " + obtenerNivelCenizasConColor(nivelCenizas)
        );

        return spannableString.toString();
    }

    // Métodos auxiliares para determinar el nivel de cada parámetro con colores
    private SpannableString obtenerNivelConColor(double valor, double bajo, double alto) {
        String nivel = obtenerNivelTexto(valor, bajo, alto);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Bajo")) {
            color = 0x00FF00; // Verde para "Bajo"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFF0000; // Rojo para "Alto"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    private SpannableString obtenerNivelTemperaturaConColor(double temperatura) {
        String nivel = obtenerNivelTemperaturaTexto(temperatura);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Bajo")) {
            color = 0x00FF00; // Verde para "Bajo"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFF0000; // Rojo para "Alto"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    private SpannableString obtenerNivelCenizasConColor(double nivelCenizas) {
        String nivel = obtenerNivelCenizasTexto(nivelCenizas);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Bajo")) {
            color = 0x00FF00; // Verde para "Bajo"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFF0000; // Rojo para "Alto"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    private String obtenerNivelTexto(double valor, double bajo, double alto) {
        if (valor < bajo) {
            return "  Nivel Bajo  ";
        } else if (valor >= bajo && valor <= alto) {
            return "  Nivel Medio  ";
        } else {
            return "  Nivel Alto  ";
        }
    }

    private String obtenerNivelTemperaturaTexto(double temperatura) {
        if (temperatura < 18) {
            return "  Nivel Bajo  ";
        } else if (temperatura >= 18 && temperatura <= 28) {
            return "  Nivel Medio  ";
        } else {
            return "Nivel Alto";
        }
    }

    private String obtenerNivelCenizasTexto(double nivelCenizas) {
        if (nivelCenizas < 5) {
            return "Nivel Vacio";
        } else if (nivelCenizas >= 5 && nivelCenizas <= 15) {
            return "Nivel Medio";
        } else {
            return "Nivel LLeno";
        }
    }
}
