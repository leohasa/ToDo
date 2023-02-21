package com.ipc2.todo.controller.tarea;

import com.ipc2.todo.datos.TareaDB;
import com.ipc2.todo.modelo.Session;
import com.ipc2.todo.view.tarea.TareaView;

import java.sql.Connection;

public class TareaController {

    private final TareaView tareaView;
    private final TareaDB tareaDB;

    public TareaController(TareaView tareaView, Connection conexion) {
        this.tareaView = tareaView;
        this.tareaDB = new TareaDB(conexion);
    }

    public void ejecutar() {
        do {
            tareaView.mostrarMenu();
            switch (tareaView.getOption()) {
                case 1 -> System.out.println("Creando tarea");
                case 2 -> tareaView.mostrarListaTareas(tareaDB.listar(Session.usuario.getId()));
                case 3 -> System.out.println("Actualizando tarea");
                case 4 -> System.out.println("Eliminando tarea");
                case 5 -> System.out.println("Volver");
                default -> System.out.println("Opcion invalida");
            }
        }while (tareaView.getOption() != 5);
    }
}
