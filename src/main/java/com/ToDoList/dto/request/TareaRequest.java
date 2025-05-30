package com.ToDoList.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaRequest {

    private Long id;
    private String titulo;
    private String descripcion;
    private Boolean completado;

}
