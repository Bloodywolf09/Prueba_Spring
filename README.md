HEAD
# Prueba_spring
origin/main

Este proyecto es un ejemplo de una aplicación CRUD (Crear, Leer, Actualizar y Eliminar) básica desarrollada utilizando Java 17, Spring Boot 3 y MySQL.
##Tecnologías Utilizadas
-JDK 19
-Spring Boot 3
-Spring security 6
-MySQL 8

##Instrucciones de Uso
Sigue estos pasos para ejecutar la aplicación en tu entorno local:

#Clonar el repositorio en tu máquina local
git clone https://github.com/Bloodywolf09/Prueba_spring.git
#Navegar al directorio del proyecto
cd CRUD-spring-boot-postgresql
Ejecutar el proyecto o correr el archivo que se encuentra en la siguiente ruta
src/main/java/co/com/gm/HolaSpringApplication.java

##Base URL
-http://localhost:8080

Login
## Iniciar sesión de usuario:

## Endpoints de Productos

| Método | Endpoint              | Descripción                          |
|--------|-----------------------|--------------------------------------|
| GET    | `/product/list`       | Obtener todos los productos          |

### Cuerpo de la solicitud:
```json
{
  "username": "admin",
  "password": "123"
}


```json
{
  "username": "user",
  "password": "123"
}


# Documentación de la API

## Endpoints de Productos

| Método | Endpoint              | Descripción                          |
|--------|-----------------------|--------------------------------------|
| GET    | `/product/list`       | Obtener todos los productos          |
| GET    | `/product/{id}`       | Obtener un solo producto             |
| POST   | `/product/add`        | Guardar un nuevo producto            |
| PUT    | `/product/update/{id}`| Actualizar un producto existente     |
| DELETE | `/product/{id}`       | Eliminar un producto                 |
