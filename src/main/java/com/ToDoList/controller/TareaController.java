package com.ToDoList.controller;

import com.ToDoList.dto.ApiResponse;
import com.ToDoList.dto.request.TareaRequest;
import com.ToDoList.dto.response.TareaResponse;
import com.ToDoList.service.TareaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(@Qualifier("cachedTareaServiceProxy") TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public ApiResponse<List<TareaResponse>> findAll() {
        return new ApiResponse<>("Traer todas las tareas", HttpStatus.OK, tareaService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<TareaResponse> findById(@PathVariable Long id) {
        return new ApiResponse<>("Traer todas las tareas", HttpStatus.OK, tareaService.findById(id));
    }

    @PostMapping
    public ApiResponse<TareaResponse> save(@RequestBody TareaRequest tareaRequest) {
        return new ApiResponse<>("guarda Tarea", HttpStatus.CREATED, tareaService.save(tareaRequest));
    }

    @PutMapping(path = "/{id}/completar")
    public ApiResponse<TareaResponse> update(@PathVariable Long id) {
        return new ApiResponse<>("actualizar tarea", HttpStatus.OK, tareaService.update(id));
    }

    @DeleteMapping(path = "/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        tareaService.delete(id);
        return new ApiResponse<>("Tarea eliminada exitosamente", HttpStatus.OK, "Se eliminó correctamente");
    }

}
