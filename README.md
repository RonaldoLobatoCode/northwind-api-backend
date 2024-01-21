

# Northwind API Backend
<p>Este proyecto implementa un backend para la gestión de productos, clientes, pedidos y empleados utilizando Spring Boot y la base de datos Northwind.</p>

# Descripción
<p>El objetivo de este proyecto es proporcionar una interfaz de programación de aplicaciones (API) RESTful para realizar operaciones CRUD en la base de datos Northwind. La aplicación se construye con Spring Boot y utiliza Spring Data JPA para la capa de acceso a datos.</p>

##  Requisitos Previos
- Spring Boot
- Mysql 
- Postman (para pruebas y exploración de la API)

## Uso de Postman
Se incluye una colección de Postman en el directorio `postman` que contiene ejemplos de solicitudes para probar las diferentes rutas de la API. Sigue estos pasos para empezar:

1. Importa la colección de Postman ubicada en `postman/northwind-api.postman_collection.json`.
2. Configura las variables de entorno en Postman según sea necesario 
3. Ejecuta las solicitudes de la colección para interactuar con la API y probar sus funcionalidades.


## Configuración del Entorno

    
	git clone https://github.com/RonaldoLobatoCode/northwind-api-backend.git
    

## Configuración
Asegúrate de configurar los siguientes archivos o propiedades:
- application.properties o application.yml para configuraciones específicas como la conexión a la base de datos MySQL, puertos, etc.
- Configura la conexión a la base de datos Northwind.
- Puede encontrar el script de la base de datos Northind en el siguiente link https://en.wikiversity.org/wiki/Database_Examples/Northwind/MySQL
