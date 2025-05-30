package com.ToDoList.service;

import com.ToDoList.dto.request.TareaRequest;
import com.ToDoList.dto.response.TareaResponse;

import java.util.List;

public interface TareaService {

    List<TareaResponse> findAll();

    TareaResponse findById(Long id);

    TareaResponse save(TareaRequest tareaRequest);

    TareaResponse update(Long id);
    void delete(Long id);

}
