package com.ipc2.todo.controller.login;

import com.ipc2.todo.controller.menu.MenuPrincipalController;
import com.ipc2.todo.datos.UsuarioDB;
import com.ipc2.todo.modelo.Session;
import com.ipc2.todo.modelo.Usuario;
import com.ipc2.todo.view.login.LoginView;
import com.ipc2.todo.view.menu.MenuPrincipal;

import java.sql.Connection;

public class LoginController {

    private final Connection conexion;
    private final LoginView loginView;
    private final UsuarioDB usuarioDB;
    private Usuario usuarioLogin;

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
            if (!usuarioValido) System.out.println("Credenciales incorrectas\n");
        }while (!usuarioValido);

        Session.usuario = usuarioLogin;
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipal, conexion);
        menuPrincipalController.ejecutar();
    }

    public boolean validarUsuario(String username, String password) {
        var oUsuario = usuarioDB.obtenerUsuario(username, password);
        if (oUsuario.isEmpty()) return false;

        usuarioLogin = oUsuario.get();
        return true;
    }
}
