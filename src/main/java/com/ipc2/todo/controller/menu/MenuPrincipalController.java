package com.ipc2.todo.controller.menu;

import com.ipc2.todo.controller.inicio.InicioController;
import com.ipc2.todo.controller.tarea.TareaController;
import com.ipc2.todo.modelo.Session;
import com.ipc2.todo.view.inicio.InicioView;
import com.ipc2.todo.view.menu.MenuPrincipal;
import com.ipc2.todo.view.tarea.TareaView;

import java.sql.Connection;

public class MenuPrincipalController {

    private final MenuPrincipal menuPrincipal;
    private final Connection conexion;

    public MenuPrincipalController(MenuPrincipal menuPrincipal, Connection conexion) {
        this.menuPrincipal = menuPrincipal;
        this.conexion = conexion;
    }

    public void ejecutar() {
        do {
            menuPrincipal.mostrarMenu(Session.usuario.getNombre());
            switch (menuPrincipal.getOption()) {
                case 1 -> {
                    TareaView tareaView = new TareaView();
                    TareaController tareaController = new TareaController(tareaView, conexion);
                    tareaController.ejecutar();
                }
                case 2 -> {
                    System.out.println("Cerrando sesion...");
                    Session.usuario = null;

                    InicioView inicioView = new InicioView();
                    InicioController inicioController = new InicioController(inicioView, conexion);
                    inicioController.ejecutar();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while (menuPrincipal.getOption() != 2);
    }
}
