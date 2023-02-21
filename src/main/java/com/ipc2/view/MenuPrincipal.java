package com.ipc2.view;

import com.ipc2.modelo.Session;

import java.util.Scanner;
public class MenuPrincipal {

    private final Scanner scanner;
    private int option;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(String username) {
        System.out.println("\nBienvenido @" + username);
        System.out.println("1. Modulo de Tareas");
        System.out.println("2. Cerrar sesion");

        option = scanner.nextInt();
    }

    public int getOption() {
        return option;
    }
}
