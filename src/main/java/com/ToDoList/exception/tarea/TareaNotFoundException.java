package com.ToDoList.exception.tarea;

public class TareaNotFoundException extends RuntimeException {

    public TareaNotFoundException(Long id) {
        super("No se encontro la tarea con id: " + id);
    }

}
