package com.ToDoList.dto.mappers;


import com.ToDoList.dto.request.TareaRequest;
import com.ToDoList.dto.response.TareaResponse;
import com.ToDoList.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TareaMappers {


    TareaMappers INSTANCE = Mappers.getMapper(TareaMappers.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "completado", target = "completado")
    Tarea tareaRequestToTarea(TareaRequest tareaRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "completado", target = "completado")
    TareaResponse tareaToTareaResponse(Tarea tarea);

    List<TareaResponse> tareaListToTareaResponseList(List<Tarea> tareas);
}
