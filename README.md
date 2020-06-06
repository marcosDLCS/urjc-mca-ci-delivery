# URJC Máster Cloud Apps<!-- omit in toc -->

## Módulo IV. Integración y entrega continua<!-- omit in toc -->

### Práctica. Configuración de un pipeline/workflow de integración continua<!-- omit in toc -->

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=marcosDLCS_urjc_mca_ci_delivery&metric=alert_status)](https://sonarcloud.io/dashboard?id=marcosDLCS_urjc_mca_ci_delivery)
[![CodeFactor](https://www.codefactor.io/repository/github/marcosdlcs/urjc_mca_ci_delivery/badge/master)](https://www.codefactor.io/repository/github/marcosdlcs/urjc_mca_ci_delivery/overview/master)
![Build & Analysis](https://github.com/marcosDLCS/urjc_mca_ci_delivery/workflows/Build%20&%20Analysis/badge.svg)


#### Tabla de contenidos<!-- omit in toc -->

- [Enunciado](#enunciado)
  - [Objetivo](#objetivo)
  - [Proyecto software](#proyecto-software)
  - [Pipeline de integración continua](#pipeline-de-integración-continua)
  - [Se pide (entregables)](#se-pide-entregables)
  - [Formato de entrega](#formato-de-entrega)
- [Aplicación](#aplicación)
  - [Enunciado de la práctica original DDD / CQRS](#enunciado-de-la-práctica-original-ddd--cqrs)
  - [Instrucciones y aclaraciones sobre la aplicación](#instrucciones-y-aclaraciones-sobre-la-aplicación)

#### Enunciado

##### Objetivo

El objetivo de la práctica es que el alumno configure un *pipeline* de integración continua de un proyecto software poniendo en práctica los conceptos vistos en la asignatura.

##### Proyecto software

El pipeline de integración continua se utilizará para la gestión del ciclo de vida de un proyecto software existente. El alumno puede elegir el proyecto que prefiera siempre que tenga pruebas unitarias y de sistema (e2e). Se valorará que el proyecto use una base de datos externa, pero no es obligatorio.

##### Pipeline de integración continua

El *pipeline* de Integración Continua deberá tener las siguientes características:

- Se podrá utilizar cualquier servidor de CI
- El proyecto software se alojará en un repositorio privado al cual se dará acceso al profesor
- Se quieren ejecutar en algún momento las siguientes cosas:
  - Tests unitarios, tan a menudo como sea posible
  - Test de sistema, al menos una vez al día
  - Análisis de calidad y seguridad con Sonar, al menos una vez al día
  - Archivado de artefactos de desarrollo en el propio CI, o en algún sistema externo
  - Empaquetado y publicación de releases estables en algún repositorio de artefactos
  - Se desea disponer todas las noches de una versión de desarrollo actualizada con los cambios del día
  
El alumno debe describir cuál es el proceso de desarrollo (ramas) del proyecto y decidir cuántos *jobs* se definen, asociados a qué eventos en el repositorio y qué hace cada uno de ellos.

##### Se pide (entregables)

Entregar un fichero pdf con la siguiente documentación:

- Asunciones sobre el modelo de desarrollo del repositorio
- Diagramas describiendo cuándo se ejecuta cada job
- Los enlaces al repositorio
- Los diferentes ficheros de configuración de los jobs

##### Formato de entrega

La práctica será individual, y se desarrollará en un repositorio privado en GitHub al cual se invitará a los profesores Patxi Gortázar (usuario GitHub: gortazar) y Michel Maes (usuario GitHub: Maes95).

#### Aplicación

##### Enunciado de la práctica original DDD / CQRS

Se desea modelar una aplicación de una *aseguradora de casas*. La aseguradora *gestiona* **contratos** de **clientes** con ciertas **coberturas**. Consideraremos las coberturas de **ventanas, fachada, y aparatos eléctricos**. La aseguradora recibe *altas* de **seguros** con ciertas coberturas, y también *recibe* **incidencias** de los clientes que tienen contratado un seguro. Estas incidencias pueden estar o no cubiertas por el seguro contratado con el cliente.

Además, en ciertas ocasiones, las incidencias son falsas: el cliente pretende cargar al seguro un problema que no es causa natural. Para determinar estas incidencias fraudulentas, la aseguradora utiliza un algoritmo que es el que sigue:

```text
Si el cliente ha notificado al menos dos incidencias anteriores, y la cantidad que han costado dichas incidencias a la aseguradora es mayor de 1000 euros, entonces hay una alta probabilidad de que sea una incidencia fraudulenta
```

Para la aseguradora es importante detectar este hecho en las nuevas incidencias, porque se utiliza para enviar a un perito más experto en estos casos.

Se pide desarrollar una **aplicación web, con API REST** (puede ser web si se prefiere), que permita dar de alta seguros de clientes con cualquier cobertura que decida el cliente. La aplicación debe permitir también abrir indicencias por parte de los clientes y consultar las incidencias abiertas de todos los clientes. No es necesario hacer el crud completo. Tampoco es necesario implementar ningún mecanismo de seguridad o de perfiles (cliente vs admin). La implementación de las consultas debe seguir el patrón CQRS, separando las escrituras de las lecturas. El mecanismo de implementación queda a decisión del alumno.

##### Instrucciones y aclaraciones sobre la aplicación

La practica está realizada con las siguientes tecnologías:

- Spring Boot y Spring Data JPA
- PostgreSQL
- Lombok
- Mapstruct
- Java Money Moneta

**Coberturas**

- WINDOWS_COVERAGE
- ELECTRONIC_DEVICES_COVERAGE
- FACADE_COVERAGE

**Tipos de incidencia**

- FLOOD
- EARTHQUAKE
- DEEP_ASTEROID_IMPACT
- TSUNAMI
- TORNADO
- ACCIDENT

Para comenzar a usarlo se han de crear primero los clientes, después los seguros y por último las incidencias. El proyecto se acompaña con un la colección de Postman (**api.postman_collection**) con las llamadas y ejemplos de los DTOs de entrada.

Hay una validación básica de llamadas. No se pueden crear seguros con casas cuyo número de registro esté en otro seguro, por ejemplo. También en base a las aserciones del modelo de dominio pueden darse respuestas **400** con el motivo de la llamada errónea. Se trata de una gestión de errores básica.

No se ha tenido en cuenta las conversiones de moneda. En el algoritmo de fraude simplemente se suman las cantidades.
