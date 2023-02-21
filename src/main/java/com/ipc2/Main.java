package com.ipc2;

import com.ipc2.controller.LoginController;
import com.ipc2.datos.Conexion;
import com.ipc2.view.LoginView;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        LoginView login = new LoginView();
        LoginController loginController = new LoginController(login, conexion.obtenerConexion());
        loginController.ejecutar();
    }
}
