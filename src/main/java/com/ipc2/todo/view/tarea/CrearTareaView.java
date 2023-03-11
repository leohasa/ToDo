package com.ipc2.todo.view.tarea;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
@Getter
public class CrearTareaView {

    private String titulo;
    private String descripcion;
    private LocalDateTime fecha = LocalDateTime.now();
    private int prioridad;
    private int estado;

    private final Scanner intScanner;
    private final Scanner stringScanner;

    public CrearTareaView() {
        intScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }

    public void mostrarMenu(String[] estados) {
        System.out.println("\nCreacion de tarea");
        System.out.print("Ingrese el titulo de la tarea: ");
        titulo = stringScanner.nextLine();
        System.out.print("Ingrese la descripcion de la tarea: ");
        descripcion = stringScanner.nextLine();
        System.out.print("Ingrese la prioridad de la tarea (1,2,3): ");
        prioridad = intScanner.nextInt();
        System.out.println("Seleccione el estado de la tarea");
        for (int i = 0; i < estados.length; i++) System.out.println((i + 1) + ". " + estados[i]);
        estado = intScanner.nextInt();
    }
}
