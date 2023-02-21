package com.ipc2.todo.controller.login;

import com.ipc2.todo.controller.menu.MenuPrincipalController;
import com.ipc2.todo.datos.UsuarioDB;
import com.ipc2.todo.modelo.Session;
import com.ipc2.todo.modelo.Usuario;
import com.ipc2.todo.view.menu.MenuPrincipal;
import com.ipc2.todo.view.login.RegistroView;

import java.sql.Connection;
import java.util.Optional;

public class RegistroController {
    private final UsuarioDB usuarioDB;
    private final RegistroView registroView;
    private final Connection conexion;

    public RegistroController(RegistroView registroView, Connection conexion) {
        this.registroView = registroView;
        this.conexion = conexion;
        this.usuarioDB = new UsuarioDB(conexion);
    }

    public void ejecutar() {
        do {
            registroView.mostrarMenu();
            switch (registroView.getOption()) {
                case 1 -> {
                    ejecutarRegistro();
                }
                case 2 -> {
                    System.out.println("Regresando al inicio...");
                }
                default -> System.out.println("Opcion invalida");
            }
        }while (registroView.getOption() != 2);
    }

    private void ejecutarRegistro() {
        registroView.mostrarRegistro();
        String username = registroView.getUsername();
        String password = registroView.getPassword();
        String nombre = registroView.getNombre();

        if (username.isEmpty() || password.isEmpty() || nombre.isEmpty()) {
            System.out.println("No puede dejar campos vacios");
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setNombre(nombre);

        usuarioDB.crear(usuario);

        Optional<Usuario> oUsuarioNuevo = usuarioDB.obtenerUsuario(username, password);
        if (oUsuarioNuevo.isPresent()) {
            Session.usuario = oUsuarioNuevo.get();
        } else {
            System.out.println("No se pudo registrar el usuario");
        }

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipal, conexion);
        menuPrincipalController.ejecutar();
    }
}
