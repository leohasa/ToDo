package com.ipc2.view.tarea;

import com.ipc2.modelo.Tarea;

import java.util.List;
import java.util.Scanner;

public class TareaView {

    private final Scanner scanner;

    public TareaView() {
        scanner = new Scanner(System.in);
    }

    private int option;

    public void mostrarMenu() {
        System.out.println("\nModulo de tareas");
        System.out.println("1. Crear tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Actualizar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Volver");

        option = scanner.nextInt();
    }

    public void mostrarListaTareas(List<Tarea> tareas) {
        System.out.println("Lista de tareas");
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public int getOption() {
        return option;
    }
}
