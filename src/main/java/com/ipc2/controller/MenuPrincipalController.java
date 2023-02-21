package com.ipc2.controller;

import com.ipc2.controller.tarea.TareaController;
import com.ipc2.modelo.Session;
import com.ipc2.view.LoginView;
import com.ipc2.view.MenuPrincipal;
import com.ipc2.view.tarea.TareaView;

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
            menuPrincipal.mostrarMenu(Session.usuario.getUsername());
            switch (menuPrincipal.getOption()) {
                case 1 -> {
                    TareaView tareaView = new TareaView();
                    TareaController tareaController = new TareaController(tareaView, conexion);
                    tareaController.ejecutar();
                }
                case 2 -> {
                    System.out.println("Cerrando sesion...");
                    LoginView loginView = new LoginView();
                    LoginController loginController = new LoginController(loginView, conexion);
                    loginController.ejecutar();
                }
                default -> System.out.println("Opcion invalida");
            }
        }while (menuPrincipal.getOption() != 2);
    }
}
