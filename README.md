#To-Do App

Enunciado: Registro de Tareas Pendientes (To-Do App básica)
🎯 Objetivo:
Crear una API REST con Spring Boot para gestionar tareas pendientes (To-Do).

✅ Funcionalidades requeridas:
Listar todas las tareas.

Agregar una nueva tarea (con título y descripción).

Marcar una tarea como completada.

Eliminar una tarea.

🧱 Estructura sugerida:
Modelo: Tarea con campos:

id (Long)

titulo (String)

descripcion (String)

completado (boolean)

Controlador REST con los siguientes endpoints:

GET /tareas → Listar todas las tareas

POST /tareas → Crear una nueva tarea

PUT /tareas/{id}/completar → Marcar como completada

DELETE /tareas/{id} → Eliminar una tarea

🛠 Requisitos técnicos:
Spring Boot

Spring Web

Datos en memoria usando List<Tarea> (sin base de datos por ahora)

Estructura limpia con paquetes separados:

model

dto

service

controller

mapper (si usas MapStruct)
