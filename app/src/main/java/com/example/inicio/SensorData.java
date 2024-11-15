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
    private double UVRadiacion;
    private double velocidadViento;
    private String clima;

    // Constructor
    public SensorData(String comuna, String calle, String sector, String dispositivo,
                      double pm25, double pm10, double co2, double co, double monoxidoCarbono,
                      double temperatura, double humedad, double nivelCenizas,
                      double UVRadiacion, double velocidadViento, String clima) {
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
        this.UVRadiacion = UVRadiacion;
        this.velocidadViento = velocidadViento;
        this.clima = clima;
    }

    // Getters y Setters
    public double getUVRadiacion() {return UVRadiacion;}

    public void setUVRadiacion(double UVRadiacion) {this.UVRadiacion = UVRadiacion;}

    public double getVelocidadViento() {return velocidadViento;}

    public void setVelocidadViento(double velocidadViento) {this.velocidadViento = velocidadViento;}

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

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

    // Método toString modificado
    @Override
    public String toString() {
        SpannableString spannableString = new SpannableString(
                "Dispositivo: " + dispositivo +"  "+
                        "Comuna: " + comuna +"  "+
                        "Calle: " + calle +"  "+
                        "Sector: " + sector +"  "+
                        "PM25: " + pm25 + " " + obtenerNivelConColor(pm25, 10, 20) +"  "+
                        "PM10: " + pm10 + " " + obtenerNivelConColor(pm10, 15, 30) +"  "+
                        "CO2: " + co2 + " " + obtenerNivelConColor(co2, 300, 600) + "\n" +"  "+
                        "CO: " + co + " " + obtenerNivelConColor(co, 0.1, 0.5) +"  "+
                        "Monóxido de Carbono: " + monoxidoCarbono + " " + obtenerNivelConColor(monoxidoCarbono, 0.1, 0.5) +"  "+
                        "Temperatura: " + temperatura + "°C " + obtenerNivelTemperaturaConColor(temperatura) +"  "+
                        "Humedad: " + humedad + "% " + obtenerNivelConColor(humedad, 30, 70) +"  "+
                        "Nivel de Cenizas: " + nivelCenizas + " " + obtenerNivelCenizasConColor(nivelCenizas) +"  "+
                        "Radiación UV: " + UVRadiacion + " " + obtenerNivelUVTexto(UVRadiacion) +"  "+
                        "Velocidad del Viento: " + velocidadViento + " km/h " + obtenerNivelVientoTexto(velocidadViento) + "  "+
                        "Clima: " + clima
        );

        return spannableString.toString();
    }

    //
        //
        //                ", clima='" + clima + '\'' +
        //                '}';//
    // Métodos auxiliares para determinar el nivel de cada parámetro con colores
    public SpannableString obtenerNivelConColor(double valor, double bajo, double alto) {
        String nivel = obtenerNivelTexto(valor, bajo, alto);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Bajo")) {
            color = 0xFF00FF00; // Verde para "Bajo"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFFFF0000; // Rojo para "Alto"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    public SpannableString obtenerNivelTemperaturaConColor(double temperatura) {
        String nivel = obtenerNivelTemperaturaTexto(temperatura);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Bajo")) {
            color = 0xFF00FF00; // Verde para "Bajo"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFFFF0000; // Rojo para "Alto"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    public SpannableString obtenerNivelCenizasConColor(double nivelCenizas) {
        String nivel = obtenerNivelCenizasTexto(nivelCenizas);
        SpannableString spannable = new SpannableString(nivel);
        int color;

        if (nivel.equals("Vacio")) {
            color = 0xFF00FF00; // Verde para "Vacio"
        } else if (nivel.equals("Medio")) {
            color = 0xFFFFFF00; // Amarillo para "Medio"
        } else {
            color = 0xFFFF0000; // Rojo para "Lleno"
        }

        spannable.setSpan(new ForegroundColorSpan(color), 0, nivel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    // Métodos auxiliares para determinar los niveles
    private String obtenerNivelTexto(double valor, double bajo, double alto) {
        if (valor < bajo) {
            return " Niveles Bajos ";
        } else if (valor >= bajo && valor <= alto) {
            return " Niveles Medios ";
        } else {
            return " Niveles Altos ";
        }
    }

    private String obtenerNivelTemperaturaTexto(double temperatura) {
        if (temperatura < 18) {
            return " Nivel Bajo ";
        } else if (temperatura >= 18 && temperatura <= 28) {
            return " Nivel Medio ";
        } else {
            return " Nivel Alto ";
        }
    }

    private String obtenerNivelCenizasTexto(double nivelCenizas) {
        if (nivelCenizas < 5) {
            return "  Vacio  ";
        } else if (nivelCenizas >= 5 && nivelCenizas <= 15) {
            return " Medio ";
        } else {
            return "  Lleno  ";
        }
    }
    private String obtenerNivelUVTexto(double UVRadiacion) {
        if (UVRadiacion < 3) {
            return " Nivel Bajo ";
        } else if (UVRadiacion >= 3 && UVRadiacion <= 6) {
            return " Nivel Medio ";
        } else {
            return " Nivel Alto ";
        }
    }
    private String obtenerNivelVientoTexto(double velocidadViento) {
        if (velocidadViento < 10) {
            return " Nivel Bajo ";
        } else if (velocidadViento >= 10 && velocidadViento <= 30) {
            return " Nivel Medio ";
        } else {
            return " Nivel Alto ";
        }
    }


}
