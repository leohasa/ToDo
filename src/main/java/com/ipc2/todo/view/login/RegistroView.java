package com.ipc2.todo.view.login;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class RegistroView {

    private int option;
    private String nombre;
    private String username;
    private String password;
    private final Scanner scanner;
    private final Scanner stringScanner;

    public RegistroView() {
        scanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nRegistro de usuario");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Volver al inicio");

        option = scanner.nextInt();
    }

    public void mostrarRegistro() {
        System.out.print("Ingrese nombre completo: ");
        nombre = stringScanner.nextLine();

        System.out.print("Ingrese nombre de usuario: ");
        username = stringScanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        password = stringScanner.nextLine();
    }
}
