# API Mantenimientos - Backend

## Descripción

Este proyecto es una API REST para la gestión de mantenimientos en un sistema CMMS (Computerized Maintenance Management System), desarrollada en Java con Spring Boot. Implementa autenticación basada en **JWT (JSON Web Tokens)** para el manejo de sesiones seguras, incluyendo tokens de acceso y de actualización.

## Estructura del Proyecto

El proyecto sigue una arquitectura basada en controladores y servicios, con las siguientes carpetas principales:

- `/controller`: Contiene los controladores REST que gestionan las solicitudes HTTP.
- `/model`: Define las entidades del modelo de datos.
- `/repository`: Interfaces que extienden **JPA** para interactuar con la base de datos.
- `/service`: Implementaciones de la lógica de negocio.
- `/util`: Clases utilitarias para operaciones comunes.
- `JwtFilter.java`: Filtro que intercepta las solicitudes para validar los tokens de autenticación.
- `ApiMantenimentosApplication.java`: Clase principal que arranca la aplicación.

## Flujo de Manejo de Tokens

### Inicio de Sesión (Login)
1. El usuario envía sus credenciales (nombre de usuario y contraseña) al servidor.
2. El servidor valida las credenciales y, si son correctas, genera un **token de acceso** y un **token de actualización**.
   - El **token de acceso** se almacena en `localStorage` o `sessionStorage` en el frontend.
   - El **token de actualización** se almacena en una **cookie HttpOnly** para mayor seguridad.

### Uso del Token de Acceso
- En cada solicitud a la API REST, el **token de acceso** se envía en los encabezados de autorización (`Authorization: Bearer <token>`).
- Si el token de acceso ha expirado, el cliente utiliza el **token de actualización** para obtener uno nuevo.

### Refrescar el Token de Acceso
1. Cuando el token de acceso expira, el cliente hace una solicitud al servidor enviando el **token de actualización**.
2. Si el token de actualización es válido, el servidor genera un nuevo **token de acceso** y lo envía de vuelta al cliente.

## Instalación

### Requisitos previos
- **JDK 21**
- **Maven**
- **MySQL** (o cualquier otra base de datos compatible con JPA)

### Pasos de instalación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/NeyrisBH/api_mantenimientos.git
   ```

2. Acceder al directorio del proyecto:
   ```bash
   cd api_mantenimientos
   ```

3. Configurar la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

4. Ejecutar el proyecto:
   ```bash
   mvn spring-boot:run
   ```

## Dependencias Principales

- **Spring Boot Starter Data JPA**: Para la gestión de la persistencia de datos con JPA.
- **Spring Boot Starter Security**: Para la implementación de seguridad con JWT.
- **Spring Boot Starter Web**: Para crear los controladores REST.
- **Spring Boot Starter Web Services**: Soporte para servicios web SOAP si es necesario.
- **JWT (JSON Web Tokens)**: Para la autenticación y manejo de tokens.
- **MySQL Connector**: Para conectarse a una base de datos MySQL.

## Scripts de Construcción

- **Compilar el proyecto**:
   ```bash
   mvn clean install
   ```

- **Ejecutar el proyecto**:
   ```bash
   mvn spring-boot:run
   ```

- **Realizar tests**:
   ```bash
   mvn test
   ```

## Manejo de Errores

- Si el **token de acceso** es inválido o ha expirado, el servidor retornará un error `401 Unauthorized`.
- Si el **token de actualización** es inválido, el cliente deberá volver a iniciar sesión.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu funcionalidad o corrección de errores.
3. Realiza los cambios y haz un commit.
4. Envía un pull request.

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).
