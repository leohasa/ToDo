package com.ipc2.todo.view.menu;

import java.util.Scanner;
public class MenuPrincipal {

    private final Scanner scanner;
    private int option;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(String nombre) {
        System.out.println("\nBienvenido @" + nombre);
        System.out.println("1. Modulo de Tareas");
        System.out.println("2. Cerrar sesion");

        option = scanner.nextInt();
    }

    public int getOption() {
        return option;
    }
}
