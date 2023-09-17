package org.example;

import java.time.LocalDateTime;
import java.util.Vector;

public class ColaCircular {
 Vector<Proceso> colaProcesos = new Vector<>(50);
 Vector<Proceso> procesosOrdenados = new Vector<>(50);

 int prioridades[] = new int[9];

 public ColaCircular() {
  crearProcesos();
 }

 public void crearProcesos() {
  for (int i = 0; i < 50; i++) {
   int quantum = (int) ((Math.random() * 100 + 1));
   Proceso proceso = new Proceso();
   proceso.setNombre("P" + i);
   proceso.setQuantum(quantum);
   colaProcesos.add(proceso);
  }
  ordenarProcesos();
 }

 public void ordenarProcesos() {
  int cantidadProcesos = 0;
  for (int i = 0; i < prioridades.length && !colaProcesos.isEmpty(); i++) {
   for (int j = 0; j < colaProcesos.size(); j++) {
    if (colaProcesos.get(j).prioridad == i) {
     Proceso p = colaProcesos.remove(j);
     procesosOrdenados.add(p);
     cantidadProcesos++;
     j--;
    }
   }
   prioridades[i] = cantidadProcesos;
   cantidadProcesos = 0;
  }
 }

 public void ejecutarProcesos() {
  int i = 0;

  while (!procesosOrdenados.isEmpty()) {
   if (prioridades[i] != 0) {
    Proceso pr = procesosOrdenados.remove(0);
    pr.ejecutar();

    if (pr.quantum > 0) {
     procesosOrdenados.add(prioridades[i] - 1, pr);
    } else {
     prioridades[i]--;
    }
   } else {
    i++;
   }
  }
 }

 public int getTamano(){
   return procesosOrdenados.size();
 }

 public Vector<Proceso> getProcesosOrdenados(){
  return this.procesosOrdenados;
 }

 public static void main(String[] args) {
  ColaCircular c = new ColaCircular();
  c.ejecutarProcesos();

 }

}