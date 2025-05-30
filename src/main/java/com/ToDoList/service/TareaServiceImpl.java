package com.ToDoList.service;

import com.ToDoList.dto.mappers.TareaMappers;
import com.ToDoList.dto.request.TareaRequest;
import com.ToDoList.dto.response.TareaResponse;
import com.ToDoList.exception.tarea.TareaNotFoundException;
import com.ToDoList.model.Tarea;
import com.ToDoList.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tareaServiceImpl")
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;
    private final TareaMappers tareaMappers;

    public TareaServiceImpl(TareaRepository tareaRepository, TareaMappers tareaMappers) {
        this.tareaRepository = tareaRepository;
        this.tareaMappers = tareaMappers;
    }

    @Override
    public List<TareaResponse> findAll() {
        List<Tarea> tareas = tareaRepository.findAll();
        return tareaMappers.tareaListToTareaResponseList(tareas);
    }

    @Override
    public TareaResponse findById(Long id) {
        return tareaRepository.findById(id)
                .map(tareaMappers::tareaToTareaResponse)
                .orElseThrow(() -> new TareaNotFoundException(id));
    }

    @Override
    public TareaResponse save(TareaRequest tareaRequest) {
        Tarea tarea = TareaMappers.INSTANCE.tareaRequestToTarea(tareaRequest);
        tareaRepository.save(tarea);
        return TareaMappers.INSTANCE.tareaToTareaResponse(tarea);
    }

    @Override
    public TareaResponse update(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new TareaNotFoundException(id));
        tarea.setCompletado(true);
        tareaRepository.save(tarea);
        return TareaMappers.INSTANCE.tareaToTareaResponse(tarea);
    }

    @Override
    public void delete(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new TareaNotFoundException(id);

        }
        tareaRepository.deleteById(id);
    }
}
