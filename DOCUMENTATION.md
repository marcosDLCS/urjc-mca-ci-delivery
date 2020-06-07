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

## Modelo de desarrollo

En este proyecto se asume un modelo de *branching* que se basa en **TBD *(Trunk Based Development)*** en el que los desarrollos de las diferentes características o *features* se realizan en pequeñas ramas con origen en máster que se integran a través del *pull requests*

Las la rama *master* se ha protegido con las siguientes políticas:

- Revisión de la *pull request* por al menos 1 persona antes de cualquier posibilidad de *merge*
- Paso de los *checks* que incluyen haber superado con éxito la ejecución del *workflow* ***pull-request.yml*** cuyo *job* es ***pull_request_build_analysis***
- Se deshabilitan los *force push* a la rama *master*
- Se deshabilitan los borrados en la rama *master*

Otras configuraciones interesantes del repositorio son:

- Habilitar únicamente los *squash merge* en las integraciones
- Eliminar las ramas origen cuando se realizan las *pull requests*

## Workflows

### Pull request

En el *workflow* de ***pull-request*** se realizan las siguientes acciones:

- Descarga del código
- Compilación del código
- Paso de tests unitarios
- Publicación en salida del *job* de los ficheros de cobertura de JaCoCo
- Paso de analisis estático con Sonar

De manera añadida se han configurado los *bots* de [DeepCode.ai](https://www.deepcode.ai/) y [CodeFactor](https://www.codefactor.io/) para que se ejecuten siempre en cada *pull request*

### Release

...

### Nightly

...
