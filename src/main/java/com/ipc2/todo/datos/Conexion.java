package com.ipc2.todo.datos;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {

    private Connection conexion = null;
    private final String url = "jdbc:mysql://localhost:3307/todo_database";
    private final String user = "asael";
    private final String password = "123";

    public Connection obtenerConexion() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e);
        }
        return null;
    }

    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("No se pudo cerrar la conexión");
                e.printStackTrace();
            }
        }
    }
}
