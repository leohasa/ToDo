package com.ipc2.view;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class LoginView {

    private String username;
    private String password;

    private final Scanner scanner;

    public LoginView() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("\nBienvenido al sistema de tareas");
        System.out.println("Ingrese su usuario y contraseña");

        System.out.print("Usuario: ");
        username = scanner.nextLine();

        System.out.print("Contraseña: ");
        password = scanner.nextLine();
    }
}
