# PRACTICANDO ESTRUCTURA HEXAGONAL

**Proyecto educativo enfocado en el aprendizaje y práctica de arquitectura hexagonal con Spring Boot**

He decidido realizar este proyecto para practicar y repasar los conceptos fundamentales de desarrollo backend moderno,
implementando patrones arquitectónicos avanzados como Clean Architecture, CQRS y Mediator Pattern.

---

## Información General del Proyecto

**Nombre:** ecommerce-api-rest
**Grupo:** com.ecommerce
**Versión:** 0.0.1-SNAPSHOT
**Descripción:** API REST educativa para sistema de E-commerce
**Java Version:** 21
**Spring Boot Version:** 4.0.3
**Enfoque:** Aprendizaje de arquitectura limpia y patrones de diseño

## Estructura del Proyecto

```
ecommerce-api-rest/
├── .idea/                          # Configuración de IntelliJ IDEA
├── .mvn/                           # Wrapper de Maven
├── src/                            # Código fuente
│   ├── main/
│   │   ├── java/                   # Código Java principal
│   │   │   └── com/ecommerce/
│   │   │       ├── common/         # Componentes comunes
│   │   │       │   ├── config/     # Configuraciones
│   │   │       │   ├── exceptions/ # Manejo de excepciones
│   │   │       │   ├── mediator/   # Patrón Mediator
│   │   │       │   └── util/       # Utilidades
│   │   │       └── product/        # Módulo de productos
│   │   │           ├── application/ # Lógica de aplicación (CQRS)
│   │   │           │   ├── command/ # Comandos (Create, Update, Delete)
│   │   │           │   ├── query/   # Consultas (GetAll, GetOne)
│   │   │           │   └── scheduling/ # Tareas programadas
│   │   │           ├── domain/      # Lógica de dominio
│   │   │           │   ├── entity/  # Entidades de dominio
│   │   │           │   ├── exception/ # Excepciones de dominio
│   │   │           │   └── port/    # Puertos (Hexagonal Architecture)
│   │   │           └── infrastructure/ # Infraestructura
│   │   │               ├── api/     # Controllers y DTOs
│   │   │               └── database/ # Persistencia
│   │   └── resources/              # Recursos de la aplicación
│   │       ├── static/uploads/products/ # Archivos subidos de productos
│   │       ├── templates/          # Plantillas
│   │       └── application.yaml    # Configuración principal
│   └── test/                       # Pruebas unitarias
├── target/                         # Archivos compilados (generados)
├── .gitattributes                  # Configuración de Git
├── .gitignore                      # Archivos ignorados por Git
├── HELP.md                         # Documentación de ayuda
├── mvnw                            # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                        # Maven Wrapper (Windows)
├── pom.xml                         # Configuración de Maven
└── README.md                       # Documentación principal
```

## Tecnologías y Dependencias

### Tecnologías Principales

- **Spring Boot 4.0.3** - Framework principal
- **Java 21** - Lenguaje de programación
- **Maven** - Gestión de dependencias y construcción
- **YAML** - Configuración de aplicación

### Dependencias Utilizadas en la Práctica

#### Dependencias Core de Spring Boot

- `spring-boot-starter-validation` - Para practicar validaciones de datos de entrada
- `spring-boot-starter-webmvc` - Creación de controladores REST y manejo de requests/responses
- `spring-boot-devtools` - Hot reload para agilizar el desarrollo durante la práctica

#### Herramientas para Reducir Boilerplate

- **Lombok** - Práctica de anotaciones para generar getters, setters, constructores automáticamente
- **MapStruct 1.6.2** - Aprendizaje de mapeo automático entre DTOs y entidades de dominio
- **lombok-mapstruct-binding 0.2.0** - Integración sin conflictos entre Lombok y MapStruct

## Conceptos Practicados en el Proyecto

### 1. Arquitectura Hexagonal (Clean Architecture)

**¿Qué se practica aquí?**

- Separación clara de responsabilidades entre dominio, aplicación e infraestructura
- Implementación de puertos y adaptadores para desacoplar componentes
- Centralización de la lógica de negocio en el dominio, independiente de frameworks

### 2. Patrón CQRS (Command Query Responsibility Segregation)

**¿Qué se aprende?**

- Separación conceptual entre operaciones de escritura (Commands) y lectura (Queries)
- Implementación de handlers específicos para cada operación
- Mejora en la organización del código y facilidad de mantenimiento

### 3. Patrón Mediator

**¿Para qué sirve?**

- Comunicación desacoplada entre controladores y lógica de aplicación
- Centralización del enrutamiento de requests a sus respectivos handlers
- Simplicidad en el manejo de dependencias

### 4. Gestión de Archivos

**Habilidades desarrolladas:**

- Implementación de upload de imágenes de productos
- Configuración de directorios de almacenamiento estático
- Creación de utilidades reutilizables para manejo de archivos

### 5. Validación de Datos

**Práctica de:**

- Validaciones automáticas en DTOs usando Bean Validation
- Anotaciones @Valid, @NotNull, @NotBlank, etc.
- Respuestas estructuradas de errores de validación

### 6. Manejo de Excepciones

**Conceptos aplicados:**

- Creación de un manejador global de excepciones (`@ControllerAdvice`)
- Diseño de excepciones específicas por dominio
- Respuestas de error consistentes y amigables para el cliente

## Flujo de la Arquitectura Implementada

### Capas de la Arquitectura Hexagonal

```
    Infrastructure Layer (API Controllers, Database)
           ↓
    Application Layer (Commands, Queries, Handlers)
           ↓
    Domain Layer (Entities, Business Rules, Ports)
```

**Flujo de una request típica:**

1. **Controller** recibe la petición HTTP
2. **Mediator** enruta la request al handler correspondiente
3. **Handler** procesa la lógica de aplicación
4. **Domain** ejecuta las reglas de negocio
5. **Infrastructure** persiste o consulta datos

## Funcionalidades del Módulo de Productos

### Operaciones Implementadas (CRUD Completo)

#### Commands (Escritura)

- **ProductCreateCommand** - Crear nuevo producto con validaciones
- **ProductUpdateCommand** - Actualizar producto existente
- **ProductDeleteCommand** - Eliminación lógica de productos

#### Queries (Lectura)

- **ProductGetAllQuery** - Listar todos los productos
- **ProductGetOneQuery** - Obtener producto por ID

### Estructura del Request/Response

- **DTOs de entrada** - Validación automática de datos
- **DTOs de salida** - Mapeo automático con MapStruct
- **Manejo de errores** - Respuestas consistentes y descriptivas

## Configuración y Ejecución del Proyecto

### Requisitos para Practicar

- **Java 21 JDK** - Versión LTS más reciente para nuevas funcionalidades
- **Maven 3.6+** - O usar el wrapper incluido (recomendado para consistencia)
- **IDE de tu preferencia** - IntelliJ IDEA, Eclipse, VS Code

### Comandos para Ejecutar

```bash
# Ejecutar con Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ejecutar con Maven local
mvn spring-boot:run

# Compilar proyecto
./mvnw clean compile

# Generar JAR
./mvnw clean package
```

---
