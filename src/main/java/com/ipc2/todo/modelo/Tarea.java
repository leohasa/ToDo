package com.ipc2.todo.modelo;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Tarea {

    public Tarea(String titulo, String descripcion, int prioridad, LocalDateTime fecha_creacion, int idUsuario, int idEstado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha_creacion = fecha_creacion;
        this.idUsuario = idUsuario;
        this.idEstado = idEstado;
    }

    private int id;
    private String titulo;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fecha_creacion;
    private int idUsuario;
    private int idEstado;
}
