package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Proceso {
    UUID PID;
    String nombre;
    LocalDateTime tCreacion;
    LocalDateTime tUltimaModificacion;
    int quantum;
    int prioridad;

    public Proceso(){
        PID = UUID.randomUUID();
        tCreacion = LocalDateTime.now();
        tUltimaModificacion = LocalDateTime.now();
        prioridad = (int) (Math.random()*9);
    }

    public void ejecutar(){
        this.quantum -=1;
        this.tUltimaModificacion = LocalDateTime.now();
    }
    public UUID getPID() {
        return PID;
    }

    public void setPID(UUID PID) {
        this.PID = PID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime gettCreacion() {
        return tCreacion;
    }

    public void settCreacion(LocalDateTime tCreacion) {
        this.tCreacion = tCreacion;
    }

    public LocalDateTime gettUltimaModificacion() {
        return tUltimaModificacion;
    }

    public void settUltimaModificacion(LocalDateTime tUltimaModificacion) {
        this.tUltimaModificacion = tUltimaModificacion;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
