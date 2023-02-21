package com.ipc2.modelo;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Tarea {
    private int id;
    private String titulo;
    private String notas;
    private int prioridad;
    private LocalDateTime fecha_creacion;
    private int idUsuario;
    private int idEstado;
}
