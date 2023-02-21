package com.ipc2.datos;

import com.ipc2.modelo.Usuario;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    private Connection conexion = null;
    private String url = "jdbc:mysql://localhost:3307/todo_database";
    private String user = "asael";
    private String password = "123";

    public void conectar() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e);
        }
    }

    public void crearUsuario(Usuario user) {
        String query = "INSERT INTO USUARIO (nombre, username, password) VALUES (?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("Usuario creado");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
        }
    }

    public void actualizarUsuario(Usuario user) {
        String query = "UPDATE USUARIO SET nombre = ?, username = ?, password = ? WHERE id_usuario = ?";

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            System.out.println("Usuario actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
    }

    public void eliminarUsuario(int id) {
        String query = "DELETE FROM USUARIO WHERE id_usuario = ?";

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
    }

    public List<Usuario> consultarUsuarios() {
        var usuarios = new ArrayList<Usuario>();
        try {
            var stmt = conexion.createStatement();
            var resultSet = stmt.executeQuery("SELECT *  FROM USUARIO");

            while (resultSet.next()) {

                var id = resultSet.getInt("id_usuario");
                var nombre = resultSet.getString("nombre");
                var username = resultSet.getString("username");
                var password = resultSet.getString("password");

                var usuario = new Usuario(id, nombre, username, password);
                usuarios.add(usuario);
            }
            stmt.close();
            resultSet.close();
        }catch (SQLException e) {
            System.out.println("Error al consultar: " + e);
        }
        return usuarios;
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
