# Plataforma de Apoyo de Salud Mental - API Backend

### Tabla de Contenidos
- [Descripción del Problema](#descripción-del-problema)
- [Descripción de la Solución](#descripción-de-la-solución)
- [Funcionalidades del Backend](#funcionalidades-del-backend)
- [Especificaciones Técnicas](#especificaciones-técnicas)
  - [Idea Innovadora](#idea-innovadora)
  - [Formato de Respuesta HTTP con JSend](#formato-de-respuesta-http-con-jsend)
  - [Manejo de Código de Estado con ResponseEntity](#manejo-de-código-de-estado-con-responseentity)
  - [Entidades y Modelos con Validaciones](#entidades-y-modelos-con-validaciones)
  - [Mapeo de Relaciones en Base de Datos](#mapeo-de-relaciones-en-base-de-datos)
  - [Documentación de Endpoints](#documentación-de-endpoints)

## Descripción del Problema

Hoy en día, muchas personas enfrentan barreras para acceder a servicios de salud mental. Esto incluye problemas como disponibilidad limitada de terapeutas, altos costos y dificultades para obtener ayuda en momentos de crisis emocional. Una respuesta rápida y eficaz puede ser crucial.

## Descripción de la Solución

La solución propuesta es una **API backend** para una plataforma que permite a los usuarios conectarse rápidamente con terapeutas disponibles, recibir recomendaciones personalizadas de recursos de autoayuda y mantener un historial de su progreso. Esta plataforma también permite que los terapeutas gestionen citas y mantengan notas sobre el progreso de cada usuario.

## Funcionalidades del Backend

1. **Registro y Autenticación de Usuarios**
   - Soporte para el registro de usuarios y terapeutas.
   - Autenticación mediante JWT para la seguridad de los endpoints.

2. **Gestión de Citas**
   - Los usuarios pueden solicitar citas de terapia.
   - Los terapeutas pueden aceptar o rechazar las solicitudes de citas.

3. **Sistema de Recomendaciones**
   - Se analizan datos del usuario para recomendar recursos de autoayuda.

4. **Historial de Sesiones y Notas**
   - Los terapeutas pueden registrar notas en el perfil del usuario.
   - Los usuarios pueden revisar su historial para ver su progreso.

5. **Documentación de Endpoints**
   - Cada endpoint está documentado para facilitar la integración y el uso por parte de otros desarrolladores.

## Especificaciones Técnicas

### Idea Innovadora

La plataforma ofrece un acceso rápido y seguro a servicios de salud mental mediante la conexión de usuarios con terapeutas en tiempo real y la generación de recomendaciones personalizadas, manteniendo un historial de progreso.
#### Formato de Respuesta HTTP con JSend
Las respuestas de la API se estructuran en formato JSend.
**Respuesta Exitosa:
```json
{
    "status": "success",
    "data": {
        "appointmentId": 123,
        "message": "Cita creada exitosamente"
    }
}

```
#### Manejo de Código de Estado con ResponseEntity
**Ejemplo de método en Kotlin para crear una cita usando ResponseEntity:
```Kotlin
@PostMapping("/appointments")
fun createAppointment(@RequestBody @Valid appointmentDto: AppointmentDto): ResponseEntity<JSendResponse> {
    val appointment = appointmentService.createAppointment(appointmentDto)
    return ResponseEntity.ok(JSendResponse.success(data = appointment, message = "Cita creada exitosamente"))
}

```
#### Entidades y Modelos con Validaciones
**Entidad Appointment:
```Kotlin
@Entity
class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var scheduledDate: LocalDateTime? = null

    @ManyToOne
    var user: User? = null

    @ManyToOne
    var therapist: Therapist? = null
    var notes: String? = null
    var status: String? = null // Ej: "Pending", "Confirmed", "Canceled"
}

```

#### DTO AppointmentDto con Validaciones:
```Kotlin
data class AppointmentDto(
    @field:NotNull(message = "User ID is required")
    var userId: Long? = null,

    @field:NotNull(message = "Therapist ID is required")
    var therapistId: Long? = null,

    @field:NotNull(message = "Scheduled date is required")
    var scheduledDate: LocalDateTime? = null,

    var notes: String? = null
)


```
#### Mapeo de Relaciones en Base de Datos
La entidad Appointment tiene relaciones Many-to-One con las entidades User y Therapist, lo que permite una relación en la que múltiples citas están asociadas a un usuario y un terapeuta.

**Ejemplo de entidad User:
```Kotlin
@Entity
class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null

    @OneToMany(mappedBy = "user")
    var appointments: List<Appointment>? = null
}

```
#### Documentación de Endpoints
Los endpoints están documentados utilizando Swagger/OpenAPI.

**Ejemplo de anotación en el controlador:
```Kotlin
@PostMapping("/appointments")
@ApiOperation("Crear una nueva cita")
@ApiResponses(
    ApiResponse(code = 200, message = "Cita creada exitosamente"),
    ApiResponse(code = 400, message = "Datos inválidos en la solicitud")
)
fun createAppointment(@RequestBody @Valid appointmentDto: AppointmentDto): ResponseEntity<JSendResponse> {
    // Implementación
}

```

