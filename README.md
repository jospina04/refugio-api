# Refugio API

API REST básica con Java y Spring Boot para gestionar las mascotas de un refugio.
Los datos se guardan en memoria (se reinician al apagar la app).

## Cómo ejecutar
Requisitos: Java 17 y Maven.

    mvn spring-boot:run

La API queda en http://localhost:8080

## Endpoints

| Método | Ruta | Descripción | Código |
|--------|------|-------------|--------|
| GET | /mascotas | Lista todas las mascotas | 200 |
| GET | /mascotas/{posicion} | Una mascota por posición (PathVariable) | 200 / 404 |
| GET | /mascotas/buscar?especie=perro | Filtra por especie (RequestParam) | 200 |
| POST | /mascotas | Agrega una mascota (RequestBody, DTO) | 201 |

Ejemplo de JSON para el POST:

    { "nombre": "Toby", "especie": "perro", "edad": 4 }

## Autora
Jimena Ospina Vergara
