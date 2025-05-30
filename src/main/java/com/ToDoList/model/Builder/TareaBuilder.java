package com.ToDoList.model.Builder;

import com.ToDoList.model.Tarea;

public class TareaBuilder {

    private Long id;
    private String titulo;
    private String descripcion;
    private Boolean completado;

    private TareaBuilder() {}

    public static TareaBuilder builder() {
        return new TareaBuilder();
    }

    public TareaBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public TareaBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }


    public TareaBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public TareaBuilder completado(Boolean completado) {
        this.completado = completado;
        return this;
    }

    public Tarea build() {
        return new Tarea(id, titulo, descripcion, completado);
    }

}
