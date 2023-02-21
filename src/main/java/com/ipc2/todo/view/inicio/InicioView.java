package com.ipc2.todo.view.inicio;

import java.util.Scanner;

public class InicioView {

    private int option;
    private Scanner scanner;
    public InicioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nBienvenido al sistema de tareas");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");

        option = scanner.nextInt();
    }

    public int getOption() {
        return option;
    }
}
