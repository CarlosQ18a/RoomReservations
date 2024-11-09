# Reservas de Habitaciones

## Descripción del Proyecto
El proyecto se trata para gestionar reservas de habitaciones, abordando problemas comunes en la industria hotelera, tales como el seguimiento de reservas, la disponibilidad de habitaciones, y la optimización de procesos de check-in/check-out. La solución emplea una estructura de respuesta uniforme y validación de datos para asegurar la integridad de la información y la experiencia del usuario.

## Características
- **Gestión de Reservas**: Creación, lectura, actualización y eliminación de reservas de habitaciones.
- **Validación de Datos**: Los DTOs (Objetos de Transferencia de Datos) incluyen validaciones para asegurar la integridad.
- **Formato de Respuesta Jsend**: Estructura de respuesta consistente utilizando el formato Jsend.
- **Códigos de Estado HTTP**: Manejo adecuado de códigos de estado HTTP con `ResponseEntity`.
- **Relaciones entre Entidades**: Estructura relacional en la base de datos.
- **Documentación de Endpoints**: Documentación completa para todos los endpoints de la API.

## Endpoints

### 1. Crear una Reserva de Habitación
- **URL**: `/api/room-reservations`
- **Método**: `POST`
- **Cuerpo de la Solicitud**:
###  Respuesta:
- Exito:

```json
{
  "status": "success",
  "data": {
    "id": 1,
    "fullName": "Andres Doe",
    "email": "Andres.d@g.com",
    "roomNumber": "101",
    "type": "Deluxe",
    "status": "Reservado",
  },
  "message": "Reserva creada exitosamente"
}
```



#### Obtener Reservas de Habitaciones
- URL: /api/room-reservations
- Método: GET
- Respuesta
```json
{
  "status": "success",
  "data": [
    {
      "id": 1,
      "fullName": "Andres Doe",
      
    },

  ]
}


```
#### Tecnologías Utilizadas
- Kotlin: Lenguaje de programación.
- Spring Boot: Framework para desarrollo de backend.
- JPA: Java Persistence API para ORM.
- Base de Datos H2: Base de datos en memoria para desarrollo y pruebas.
- Jakarta Validation: Validación de campos en DTOs.

#### DEstructura del Código
##### DTOs
- CustomerDto: Objeto de Transferencia de Datos con validación para campos como fullName, email, phone y address.
##### Entidades
- RoomReservation: Representa la entidad de reserva con campos como roomNumber, type, price, checkIn, checkOut y status.
##### Capa de Servicio
- CustomerService: Gestiona la lógica de reservas y se conecta con la capa de repositorio.
##### Capa de Repositorio
- RoomReservationRepository: Interfaz de repositorio para la entidad RoomReservation.
##### Estructura de Respuesta
Utiliza una estructura de respuesta Jsend con los siguientes tipos:
- success: Indica una operación exitosa.
- fail: Para errores del cliente con detalles sobre problemas de validación.
- error: Para errores inesperados del servidor.


#### Base de Datos
Este proyecto utiliza una base de datos H2 con la siguiente estructura para la tabla room_reservations:
```sql
CREATE TABLE room_reservations (
  id SERIAL,
  room_number VARCHAR(50) NOT NULL,
  type VARCHAR(50) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  customer VARCHAR(255),
  check_in DATE,
  check_out DATE,
  status VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);


```

