# Documentación<!-- omit in toc -->

## Tabla de contenidos<!-- omit in toc -->

- [Proyecto](#proyecto)
- [Modelo de desarrollo](#modelo-de-desarrollo)
- [Workflows](#workflows)
  - [Pull request](#pull-request)
  - [Release](#release)
  - [Nightly](#nightly)

## Proyecto

URL del proyecto: [marcosDLCS/urjc_mca_ci_delivery](https://github.com/marcosDLCS/urjc_mca_ci_delivery)

URL del repositorio de artefactos:

## Modelo de desarrollo

En este proyecto se asume un modelo de *branching* que se basa en **TBD *(Trunk Based Development)*** en el que los desarrollos de las diferentes características o *features* se realizan en pequeñas ramas con origen en máster que se integran a través del *pull requests*

Las la rama *master* se ha protegido con las siguientes políticas:

- Paso de los *checks* que incluyen haber superado con éxito la ejecución del *workflow* ***pull-request.yml*** cuyo *job* es ***pull_request_build_analysis***
- Se deshabilitan los *force push* a la rama *master*
- Se deshabilitan los borrados en la rama *master*
- **[NO ACTIVADO]:** Revisión de la *pull request* por al menos 1 persona antes de cualquier posibilidad de *merge*. Sería recomendable tenerlo activado pero al ser una práctica de única única persona no se ha considerado viable.

Otras configuraciones interesantes del repositorio son:

- Habilitar únicamente los *squash merge* en las integraciones
- Eliminar las ramas origen cuando se realizan las *pull requests*

## Workflows

### Pull request

En el *workflow* de ***pull-request*** se realizan las siguientes acciones:

- Descarga del código
- Recuperación de las dependencias en caché
- Compilación del código
- Paso de tests unitarios y *slice tests*
- Publicación en salida del *job* de los ficheros de cobertura de JaCoCo (exec y XML)
- Paso de análisis estático con Sonar
- Tareas automáticas de Github Actions *post-workflow* 

<p align="center">
  <img width="300" src="resources/img/pr_workflow.png">
</p>

De manera añadida se han configurado los *bots* de [DeepCode.ai](https://www.deepcode.ai/) y [CodeFactor](https://www.codefactor.io/) para que se ejecuten siempre en cada *pull request*

<p align="center">
  <img width="400" src="resources/img/pr_checks.png">
</p>

### Release

En el *workflow* de ***release*** se realizan las siguientes acciones:

- Descarga del código
- Recuperación de las dependencias en caché
- Cambio de la versión actual del código a una con el siguiente esquema: **<version>.-RELEASE**
- Compilación del código
- Paso de tests unitarios, *slice tests* y test de integración (Rest Assured + TestContainers)
- Creación del artefacto **.jar**
- Publicación en salida del *job* de los ficheros de cobertura de JaCoCo (exec y XML)
- Paso de análisis estático con Sonar
- Publicación del artefacto en GitHub Packages
- Tareas automáticas de Github Actions *post-workflow*

<p align="center">
  <img width="300" src="resources/img/release_workflow.png">
</p>

El artefacto resultante se puede consultar en la sección de paquetes del repositorio:

<p align="center">
  <img width="400" src="resources/img/release_artifact.png">
</p>

### Nightly

En el *workflow* de ***nightly*** se realizan las siguientes acciones:

- Descarga del código
- Recuperación de las dependencias en caché
- Cambio de la versión actual del código a una con el siguiente esquema: **<version>.<sha-8-posiciones>-SNAPSHOT**
- Compilación del código
- Paso de tests unitarios, *slice tests* y test de integración (Rest Assured + TestContainers)
- Creación del artefacto **.jar**
- Publicación en salida del *job* de los ficheros de cobertura de JaCoCo (exec y XML)
- Paso de análisis estático con Sonar
- Paso de análisis de dependencias de OWASP y publicación de resultados
- Fase de tests de mutación y publicación de resultados
- Publicación del artefacto en GitHub Packages
- Tareas automáticas de Github Actions *post-workflow*

<p align="center">
  <img width="300" src="resources/img/nightly_workflow.png">
</p>

El *workflow* se lanza cada día a las 3:01AM de la mañana siguiendo el formato de crontab **[1 3 * * *]**
