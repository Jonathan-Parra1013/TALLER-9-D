# Proyecto ParqueaderoSOLID

Este es el proyecto ParqueaderoSOLID. Empezamos con una versión inicial en la carpeta `00-inicio` que traía un código con todo mezclado y violando los cinco principios a propósito (igual que en el ejercicio de nómina). 

La idea de este repositorio es mostrar cómo arreglar ese desastre paso a paso. Cada carpeta es un paso nuevo donde copié lo de la carpeta anterior y le apliqué el principio correspondiente. Todas las líneas que cambié tienen un comentario que empieza con `// Paso`. 

Para probar cualquiera de las carpetas, simplemente compilen y ejecuten con:
`javac *.java && java Main`

## Resumen de Cambios (Principios SOLID)

Aquí dejé todo súper completo para que vean qué fue lo que se le hizo al código en cada paso:

| Carpeta | Principio SOLID | Problema que había | Lo que agregué / cambié |
| :--- | :--- | :--- | :--- |
| **01-responsabilidad-unica** | SRP (Responsabilidad Única) | `GestorParqueadero` hacía de todo: calculaba cobros, guardaba, mandaba SMS y exportaba a CSV. | Saqué la exportación a CSV y el envío del SMS a sus propias clases (`ExportadorCSV` y `NotificadorSMS`). El gestor ahora solo coordina con un método `cerrarMes` y calcula el cobro. |
| **02-abierto-cerrado** | OCP (Abierto/Cerrado) | Había un `switch` gigante que validaba el tipo de vehículo ("MENSUAL", "MINUTOS"). Si metíamos otro, tocaba modificar el gestor. | Quité el `switch`. Volví `Vehiculo` una clase abstracta y cada modelo de cobro pasó a ser una subclase (`VehiculoMensual`, `VehiculoPorMinutos`). Para demostrarlo, agregué `VehiculoPorDia` sin tocar ninguna clase que ya existía. |
| **03-sustitucion-liskov** | LSP (Sustitución de Liskov) | La clase `Bicicleta` obligaba a implementar `calcularPuntos()`, pero como no daban puntos, lanzaba una excepción. Prometía algo que no cumplía. | Corregí la jerarquía. Quité ese método de la clase base y creé una interfaz `Fidelizable`. Ahora solo los vehículos que de verdad acumulan puntos implementan esa interfaz y la bici ya no se rompe. |
| **04-segregacion-interfaces** | ISP (Segregación de Interfaces) | La interfaz `ServicioParqueadero` obligaba a la clase `Casillero` a tener métodos de lavado y seguro vacíos, porque a un casillero no se le hace eso. | Dividí esa interfaz gigante en interfaces chiquitas y específicas por capacidad (`Registrable`, `Asegurable`, `Lavable`). Ahora el casillero solo implementa lo que de verdad usa. |
| **05-inversion-dependencias** | DIP (Inversión de Dependencias) | El `GestorParqueadero` instanciaba directamente con `new` a `RepositorioMySQL`, quedando amarrado a la base de datos. | Hice que el gestor dependa de una interfaz `Repositorio` que se le pasa por el constructor. Creé un `RepositorioMemoria` para poder probar todo el sistema sin necesidad de conectarme a la base de datos real. |