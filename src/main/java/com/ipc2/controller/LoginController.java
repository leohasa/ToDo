package com.ipc2.controller;

import com.ipc2.datos.UsuarioDB;
import com.ipc2.modelo.Session;
import com.ipc2.modelo.Usuario;
import com.ipc2.view.LoginView;
import com.ipc2.view.MenuPrincipal;

import java.sql.Connection;
import java.util.Optional;

public class LoginController {

    private final Connection conexion;
    private final LoginView loginView;
    private final UsuarioDB usuarioDB;

    public LoginController(LoginView loginView, Connection conexion) {
        this.loginView = loginView;
        this.conexion = conexion;
        this.usuarioDB = new UsuarioDB(conexion);
    }

    public void ejecutar() {
        boolean usuarioValido;

        do {
            loginView.show();
            usuarioValido = validarUsuario(loginView.getUsername(), loginView.getPassword());
            if (!usuarioValido) {
                System.out.println("Credenciales incorrectas\n");
            }
        }while (!usuarioValido);

        Session.usuario = usuarioDB.obtenerUsuario(loginView.getUsername(), loginView.getPassword()).get();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipal, conexion);
        menuPrincipalController.ejecutar();
    }

    public boolean validarUsuario(String username, String password) {
        var oUsuario = usuarioDB.obtenerUsuario(username, password);
        return oUsuario.isPresent();
    }
}
