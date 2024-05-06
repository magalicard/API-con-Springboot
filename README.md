<h1>API REST Spring MVC</h1>

Esta API está construida utilizando Spring MVC, proporcionando una interfaz RESTful tradicional  para gestionar datos de clientes. Se basa en las siguientes tecnologías:

- Java 1.8
- Spring MVC
- Hibernate (potencialmente para acceso a datos)
- MySQL (probablemente para la base de datos)


**Componentes Clave**

- **ClienteController.java:** Esta clase maneja las solicitudes de los usuarios relacionadas con la gestión de clientes, incluyendo:
  - Obtener todos los clientes (getAll())
  - Obtener un cliente específico por ID (get(long id))
  - Registrar un nuevo cliente (register(@RequestBody User user))
  - Actualizar un cliente existente (update(@RequestBody User user))
  - Eliminar un cliente (delete(long id))

- **ClienteService.java:** Esta interfaz  define métodos para la lógica central del cliente, manejados por ClienteServiceImp.java.
- **Cliente.java:** Esta clase representa la estructura de una entidad cliente, incluyendo sus atributos.
- **application.properties:** Este archivo contiene la configuración de la aplicación, como los detalles de la conexión a la base de datos (si es aplicable).


<h2>Gestión de Clientes:</h2>

- GET /clientes: Obtiene todos los clientes
- GET /clientes/{id}: Obtiene un cliente específico por ID
- POST /clientes: Registra un nuevo cliente (proporcione los datos del cliente en el cuerpo de la solicitud)
- PUT /clientes/{id}: Actualiza un cliente existente (proporcione los datos del cliente actualizados en el cuerpo de la solicitud)
- DELETE /clientes/{id}: Elimina un cliente
