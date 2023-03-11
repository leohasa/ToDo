package com.ipc2.todo.view.tarea;

import com.ipc2.todo.modelo.Tarea;

import java.util.List;
import java.util.Scanner;

public class TareaView {

    private final Scanner scanner;
    private final Scanner stringScanner;

    public TareaView() {
        scanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }

    private int option;

    public void mostrarMenu() {
        System.out.println("\nModulo de tareas");
        System.out.println("1. Crear tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Volver");

        option = scanner.nextInt();
    }

    public void mostrarListaTareas(List<Tarea> tareas) {
        if(tareas.isEmpty()){
            System.out.println("No hay tareas registradas");
        }
        else {
            System.out.println("Lista de tareas");
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
        stringScanner.nextLine();
    }

    public int getOption() {
        return option;
    }
}
