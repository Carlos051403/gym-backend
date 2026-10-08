# Gym Management Backend

API REST desarrollada con Spring Boot para la gestión integral de un centro de fitness y seguimiento de rutinas de entrenamiento.

## 🚀 Tecnologías utilizadas
* **Java** (Programación Orientada a Objetos)
* **Spring Boot** (Inyección de dependencias y creación de endpoints REST)
* **Spring Data JPA / Hibernate** (Mapeo objeto-relacional y persistencia de datos)
* **MySQL** (Base de datos relacional)
* **Maven** (Gestión de dependencias)

## 📂 Estructura del Proyecto
El proyecto sigue una arquitectura limpia orientada a capas:
* `controller`: Endpoints y gestión de peticiones HTTP.
* `service`: Lógica de negocio de la aplicación.
* `repository`: Interfaces de acceso a datos con Spring Data JPA.
* `entity`: Modelos de datos mapeados a la base de datos relacional.

## ⚙️ Cómo ejecutar el proyecto en local
1. Clona este repositorio en tu máquina.
2. Configura los parámetros de conexión a tu base de datos MySQL en el archivo `application.properties`.
3. Ejecuta el proyecto mediante Maven:
   ```bash
   mvn spring-boot:run
