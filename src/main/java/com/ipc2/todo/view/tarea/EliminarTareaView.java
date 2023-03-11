package com.ipc2.todo.view.tarea;

import com.ipc2.todo.modelo.Tarea;

import java.util.List;

public class EliminarTareaView {

    private int id;

    public EliminarTareaView() {
    }

    public void mostrarMenu(List<Tarea> tareas) {
        System.out.println("\nEliminacion de tarea");
        System.out.println("Seleccione la tarea a eliminar");
        tareas.forEach(tarea -> System.out.println(tarea.getId() + ". " + tarea.getTitulo()));
        System.out.print("Ingrese el id de la tarea a eliminar: ");
        id = new java.util.Scanner(System.in).nextInt();
    }

    public int getId() {
        return id;
    }
}
