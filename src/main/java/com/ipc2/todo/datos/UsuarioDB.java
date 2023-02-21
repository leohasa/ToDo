package com.ipc2.todo.datos;

import com.ipc2.todo.modelo.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDB {

    private Connection conexion;
    public UsuarioDB(Connection conexion) {
        this.conexion = conexion;
    }
    public void crear(Usuario user) {
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

    public void actualizar(Usuario user) {
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

    public void eliminar(int id) {
        String query = "DELETE FROM USUARIO WHERE id_usuario = ?";

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
    }

    public List<Usuario> listar() {
        var usuarios = new ArrayList<Usuario>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT *  FROM USUARIO")) {

            while (resultSet.next()) {

                var id = resultSet.getInt("id_usuario");
                var nombre = resultSet.getString("nombre");
                var username = resultSet.getString("username");
                var password = resultSet.getString("password");

                var usuario = new Usuario(id, nombre, username, password);
                usuarios.add(usuario);
            }
        }catch (SQLException e) {
            System.out.println("Error al consultar: " + e);
        }
        return usuarios;
    }

    public Optional<Usuario> obtenerUsuario(String username, String password) {
        String query = "SELECT * FROM USUARIO WHERE username = ? AND password = ?";
        Usuario usuario = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    var id = resultSet.getInt("id_usuario");
                    var nombre = resultSet.getString("nombre");
                    usuario = new Usuario(id, nombre, username, password);
                }
            }
        }catch (SQLException e) {
            System.out.println("Error al consultar: " + e);
        }

        return Optional.ofNullable(usuario);
    }
}
