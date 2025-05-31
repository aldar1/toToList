# 📝 To-Do App (API REST con Spring Boot)

Una API REST básica para gestionar tareas pendientes, diseñada con buenas prácticas de arquitectura, patrones de diseño y capas bien definidas.

---

## 🎯 Objetivo

Crear una aplicación To-Do con funcionalidades CRUD, patrones de diseño como **Builder** y **Proxy**, y uso de **DTOs y Mappers** para separación de capas.

---

## ✅ Funcionalidades

- 📋 Listar todas las tareas
- ➕ Crear una nueva tarea
- ✅ Marcar una tarea como completada
- ❌ Eliminar una tarea

---

## 🧱 Estructura del Modelo

### Clase: `Tarea`

| Campo         | Tipo     | Descripción                      |
|---------------|----------|----------------------------------|
| `id`          | Long     | Identificador único de la tarea |
| `titulo`      | String   | Título de la tarea              |
| `descripcion` | String   | Descripción de la tarea         |
| `completado`  | boolean  | Indica si está completada       |

---

## 🧩 Patrones de Diseño Implementados

- 🧱 **Builder Pattern**: Para crear instancias de `Tarea` de forma más legible y flexible.
  - Uso: `Tarea tarea = TareaBuilder.builder().titulo("Estudiar").descripcion("Leer Spring").build();`
  
- 🧠 **Proxy Pattern**: Utilizado para aplicar cache en el listado de tareas, mejorando el rendimiento cuando hay muchas solicitudes.
  - El proxy se encarga de devolver resultados cacheados si no ha habido cambios.

---

## 🔄 Uso de DTOs y MapStruct

- **DTOs** (`TareaRequest`, `TareaResponse`) usados para separar la lógica de la API del modelo interno.
- **Mappers** generados automáticamente con [MapStruct](https://mapstruct.org/), facilitando la conversión entre entidades y DTOs.

```java
@Mapper(componentModel = "spring")
public interface TareaMapper {
    Tarea tareaRequestToTarea(TareaRequest request);
    TareaResponse tareaToTareaResponse(Tarea tarea);
    List<TareaResponse> tareaListToTareaResponseList(List<Tarea> tareas);
}
