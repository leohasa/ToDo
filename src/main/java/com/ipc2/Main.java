package com.ipc2;

import com.ipc2.datos.Conexion;
import com.ipc2.modelo.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // conectar a la base de datos
        var conexion = new Conexion();
        conexion.conectar();

        // crear usuario
        var usuario = new Usuario("Asael Hernandez", "asael", "123");
        conexion.crearUsuario(usuario);

        // actualizar usuario
        var usuario2 = new Usuario(2, "Asael Hernandez", "asaHdz", "qwerty");
        conexion.actualizarUsuario(usuario2);

        // eliminar usuario
        conexion.eliminarUsuario(2);

        // consultar usuarios
        var usuarios = conexion.consultarUsuarios();

        for (Usuario user : usuarios) {
            System.out.println(usuario);
        }

        // cerrar conexión
        conexion.desconectar();
    }
}
