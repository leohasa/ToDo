package com.ipc2.todo.modelo;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String password;
}
