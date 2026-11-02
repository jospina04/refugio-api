# Refugio API

API REST con Java, Spring Boot, JPA e Hibernate para gestionar las mascotas de un refugio. Los datos se guardan en una base de datos H2 mientras la aplicación está encendida.

**Contexto seleccionado:** refugio de mascotas (continuación de la Actividad Colaborativa #1).

## Integrantes
- Jimena Ospina Vergara

## Tecnologías
- Java 17
- Spring Boot 3.3.5
- Spring Data JPA / Hibernate
- Base de datos H2
- Maven

## Cómo ejecutar
Requisitos: Java 17 y Maven.

    mvn spring-boot:run

La API queda en http://localhost:8080. Consola de la base de datos: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:refugiodb`, usuario `sa`, sin contraseña).

## Estructura
- `Mascota`: entidad JPA (id, nombre, especie, edad, estado).
- `MascotaRepository`: interfaz que extiende `JpaRepository`.
- `MascotaController`: endpoints REST.

## Endpoints

| Método | Ruta | Descripción | Código |
|--------|------|-------------|--------|
| POST | /mascotas | Crea una mascota | 201 |
| GET | /mascotas | Lista todas | 200 |
| GET | /mascotas/{id} | Consulta por id | 200 / 404 |
| GET | /mascotas/buscar?especie=perro | Consulta personalizada por especie | 200 |
| PUT | /mascotas/{id} | Actualiza una mascota | 200 / 404 |
| DELETE | /mascotas/{id} | Elimina una mascota | 204 / 404 |

## Ejemplo
Solicitud `POST /mascotas`:

    { "nombre": "Toby", "especie": "perro", "edad": 4, "estado": "disponible" }

Respuesta `201 Created`:

    { "id": 1, "nombre": "Toby", "especie": "perro", "edad": 4, "estado": "disponible" }

## Nota
Los datos viven en H2 en memoria: se conservan entre peticiones, pero se reinician al apagar la aplicación.
