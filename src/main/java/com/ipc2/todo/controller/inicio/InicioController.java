package com.ipc2.todo.controller.inicio;

import com.ipc2.todo.controller.login.LoginController;
import com.ipc2.todo.controller.login.RegistroController;
import com.ipc2.todo.view.inicio.InicioView;
import com.ipc2.todo.view.login.LoginView;
import com.ipc2.todo.view.login.RegistroView;

import java.sql.Connection;

public class InicioController {

    private final InicioView inicioView;
    private final Connection conexion;
    public InicioController(InicioView inicioView, Connection conexion) {
        this.inicioView = inicioView;
        this.conexion = conexion;
    }

    public void ejecutar() {
        do {
            inicioView.mostrarMenu();
            switch (inicioView.getOption()) {
                case 1 -> {
                    LoginView loginView = new LoginView();
                    LoginController loginController = new LoginController(loginView, conexion);
                    loginController.ejecutar();
                }
                case 2 -> {
                    RegistroView registroView = new RegistroView();
                    RegistroController registroController = new RegistroController(registroView, conexion);
                    registroController.ejecutar();
                }
                case 3 -> {
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                }
                default -> System.out.println("Opcion invalida");
            }
        }while (inicioView.getOption() != 3);
    }
}
