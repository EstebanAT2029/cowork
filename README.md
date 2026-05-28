# API REST - Gestión de Salas y Reservas

## Datos del Alumno

* Nombre: Esteban Apaza Ticona
* Curso: Java FullStack
* Proyecto: API REST Reserva de Salas y Reservas
* Tecnología: Java 17 + Spring Boot

---

# Descripción del Proyecto

La aplicación permite gestionar salas de reuniones y reservas para oficinas compartidas mediante una API REST desarrollada con Spring Boot.

El sistema implementa arquitectura en capas, DTOs, validaciones, manejo global de excepciones y almacenamiento en memoria usando listas.

---

# Tecnologías Utilizadas

* Java 17
* Spring Boot
* Maven
* Spring Web
* Bean Validation
* IntelliJ IDEA
* Postman
* Word

---

# Cómo Ejecutar el Proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/EstebanAT2029/cowork.git
```

---

## 2. Ingresar al proyecto

```bash
cd EstebanAT
```

---

## 3. Ejecutar la aplicación

Linux / Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

---

## 4. Puerto de ejecución

```text
http://localhost:9090
```

---

# Endpoints Disponibles

## Información

| Método | Ruta        | Descripción                   |
| ------ | ----------- |-------------------------------|
| GET    | /api/info   | Información de la API y Autor |

---

# Endpoints de Salas

| Método | Ruta            |
| ------ | --------------- |
| GET    | /api/salas      |
| GET    | /api/salas/{id} |
| POST   | /api/salas      |
| PUT    | /api/salas/{id} |
| DELETE | /api/salas/{id} |

---

# Endpoints de Reservas

| Método | Ruta                                        |
| ------ | ------------------------------------------- |
| GET    | /api/reservas                               |
| GET    | /api/reservas/{id}                          |
| GET    | /api/reservas/sala/{salaId}                 |
| GET    | /api/reservas/estado?estado=PENDIENTE       |
| POST   | /api/reservas                               |
| POST   | /api/reservas/{id}/archivo                  |
| DELETE | /api/reservas/{id}                          |

---

# Arquitectura en Capas

## Controller

Recibe las solicitudes HTTP desde el cliente y delega el procesamiento al Service. Gestiona rutas, parámetros y respuestas HTTP.

## Service

Contiene las reglas de negocio del sistema, validaciones y coordinación entre Repository y Mapper.

## Repository

Simula la persistencia de datos utilizando listas en memoria (`List<>`) y contadores automáticos (`AtomicLong`).

## DTO

Permite transportar datos entre capas sin exponer directamente las entidades del modelo.

## Mapper

Convierte objetos Model a DTO y viceversa, manteniendo desacoplada la arquitectura.

---

# Funcionalidades Implementadas

* CRUD completo de Salas
* CRUD de Reservas
* Validaciones con Bean Validation
* Manejo global de excepciones
* Filtros por estado y sala
* Subida de archivos con MultipartFile
* Soft Delete de salas
* Validación de horarios
* Prevención de cruce de reservas
---
# Autor

Esteban Apaza Ticona

