package com.ipc2.todo;

import com.ipc2.todo.controller.inicio.InicioController;
import com.ipc2.todo.datos.Conexion;
import com.ipc2.todo.view.inicio.InicioView;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        InicioView inicioView = new InicioView();
        InicioController inicioController = new InicioController(inicioView, conexion.obtenerConexion());
        inicioController.ejecutar();
    }
}
