# Prácticas presenciales - Acceso a datos

Para esta asignatura, hemos desarrollado una API con Spring Boot, que conecta con una base de datos relacional. 

- El modelo tiene 2 clases **Team** y **Stadium**, relacionados entre sí, con sus correspondientes atributos. 

- Sobre cada una de las clases se pueden realizar las **operaciones CRUD** y se controlan las https responses **400, 404 y 500** , ademas de las **200 y 201** donde corresponda. 

- En ambas clases, hay una **operación GET** en la que se pude filtrar por el campo ID.

- La api cuenta con un **fichero OpenAPI 3.0** (leagueapi.yaml) en el que se definen las operaciones y los casos de error. 

- Cuenta con un **log** para crear trazas de errores y de ejecución.

- Se incluye una **colección Postman**

- Se usan las **reglas de validación** para los atributos del modelo de datos

- La API registra las **trazas de todas las operaciones y errores** que se produzcan. 
