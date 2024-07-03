HEAD
# Prueba_spring
origin/main

Este proyecto es un ejemplo de una aplicación CRUD (Crear, Leer, Actualizar y Eliminar) básica desarrollada utilizando Java 17, Spring Boot 3 y MySQL.  

**Tecnologías Utilizadas**  
-JDK 19  
-Spring Boot 3  
-Spring security 6  
-MySQL 8  

Se adjunta tambien la BD que esta nombrada como Test.sql  

En el caso de que se requiera configurar el puerto del aplicativo o usuario y contraseñas del servidor de la Base de datos, se deben modificar en la siguiente ruta:  
src/main/resources/aplication.properties

**Instrucciones de Uso**  
Sigue estos pasos para ejecutar la aplicación en tu entorno local:

**Clonar el repositorio en tu máquina local**  
git clone https://github.com/Bloodywolf09/Prueba_spring.git  
**Navegar al directorio del proyecto**  
cd CRUD-spring-boot-postgresql  
Ejecutar el proyecto o correr el archivo que se encuentra en la siguiente ruta  
src/main/java/co/com/gm/HolaSpringApplication.java  

**Base URL**
-http://localhost:8080

Login
**Iniciar sesión de usuario:**

## Endpoints de Login

| Método | Endpoint        | Descripción                         |
|--------|-----------------|-------------------------------------|
| POST    | `/login`       | Inicio de sesion de usuario         |

### Cuerpo de la solicitud:
```json
{
  "username": "admin",
  "password": "123"
}


{
  "username": "user",
  "password": "123"
}
```

# Documentación de la API

## Endpoints de Usuarios

| Método | Endpoint              | Descripción                          |
|--------|-----------------------|--------------------------------------|
| GET    | `/`                   | Obtener todos los productos          |
| POST   | `/agregar`            | Guardar un nuevo usuario             |
| PUT    | `/editar/{idPersona}` | Actualizar un usuario existente      |
| DELETE | `/eliminar/{id}`      | Eliminar un Usuario                  |


Obtener todos los Usuarios : GET /

Respuesta exitosa:

```json
{
  "idPersona": 1,
  "nombre": "Juanito",
  "apellido": "Juarez",
  "email": "jjuarez@gmail.com",
  "telefono": "3214567899"
},
{
  "idPersona": 2,
  "nombre": "Karla Ruiz",
  "apellido": "Gomez",
  "email": "karla@gmail.com",
  "telefono": "3215555555"
}
//.. otros usuarios
```

Crear un nuevo Usuario: POST /agregar

Cuerpo de la solicitud

```json
{
  "nombre": "Manuel",
  "apellido": "Manrique",
  "email": "mmanrique@gmail.com",
  "telefono": "555555555"
},
{
  "idPersona": 20,
  "nombre": "Manuel",
  "apellido": "Manrique",
  "email": "mmanrique@gmail.com",
  "telefono": "555555555"
}
```

Actualizar un usuario existente: PUT /editar/{idPersona}

Parámetros:
{idPersona}: ID del usuario que se va a actualizar

Solicitud:
```json
{
  "idPersona": 1,
  "nombre": "asd",
  "apellido": "aaa",
  "email": "striaang@gmail.com",
  "telefono": "1232124"
}
```
Respuesta:
```json
{
  "idPersona": 1,
  "nombre": "asdaa",
  "apellido": "aaaaff",
  "email": "striaassng@gmail.com",
  "telefono": "1232124666"
}
```
