package com.ToDoList.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse<T> {

    private String mensaje;
    private HttpStatus status;
    private T data;

    public ApiResponse(String mensaje, HttpStatus status, T data) {
        this.mensaje = mensaje;
        this.status = status;
        this.data = data;
    }


}
