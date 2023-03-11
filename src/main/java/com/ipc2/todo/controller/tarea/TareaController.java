package com.ipc2.todo.controller.tarea;

import com.ipc2.todo.datos.TareaDB;
import com.ipc2.todo.modelo.Session;
import com.ipc2.todo.modelo.Tarea;
import com.ipc2.todo.view.tarea.CrearTareaView;
import com.ipc2.todo.view.tarea.EliminarTareaView;
import com.ipc2.todo.view.tarea.TareaView;

import java.sql.Connection;

public class TareaController {

    private final TareaView tareaView;
    private final CrearTareaView crearTareaView;
    private final EliminarTareaView eliminarTareaView;
    private final TareaDB tareaDB;

    public TareaController(TareaView tareaView, Connection conexion) {
        this.tareaView = tareaView;
        this.tareaDB = new TareaDB(conexion);
        this.crearTareaView = new CrearTareaView();
        this.eliminarTareaView = new EliminarTareaView();
    }

    public void ejecutar() {
        do {
            tareaView.mostrarMenu();
            switch (tareaView.getOption()) {
                case 1 -> crearTarea();
                case 2 -> tareaView.mostrarListaTareas(tareaDB.listar(Session.usuario.getId()));
                case 3 -> eliminarTarea();
                case 4 -> System.out.println("Volver");
                default -> System.out.println("Opcion invalida");
            }
        }while (tareaView.getOption() != 4);
    }

    private void eliminarTarea() {
        eliminarTareaView.mostrarMenu(tareaDB.listar(Session.usuario.getId()));
        tareaDB.eliminar(eliminarTareaView.getId());
    }

    private void crearTarea() {
        crearTareaView.mostrarMenu(new String[] { "Pendiente", "En proceso", "Finalizada" });
        Tarea tarea = new Tarea(
                crearTareaView.getTitulo(),
                crearTareaView.getDescripcion(),
                crearTareaView.getPrioridad(),
                crearTareaView.getFecha(),
                Session.usuario.getId(),
                crearTareaView.getEstado()
        );
        tareaDB.insertar(tarea);
    }
}
