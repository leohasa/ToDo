package com.ipc2.todo.view.login;

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
        System.out.println("\nInicio de sesion");
        System.out.println("Ingrese su usuario y contraseña");

        System.out.print("Usuario: ");
        username = scanner.nextLine();

        System.out.print("Contraseña: ");
        password = scanner.nextLine();
    }
}
