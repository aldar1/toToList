package com.ToDoList.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaResponse {

    private Long id;
    private String titulo;
    private String descripcion;
    private Boolean completado;

}
