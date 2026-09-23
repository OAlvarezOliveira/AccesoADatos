# Plan Java — base general en 30–45 días (puente para Acceso a Datos)

**Estado:** el temario/UDs oficial de Acceso a Datos aún no está disponible. Las Fases 1–2 no dependen de él (arrancar ya), y se ejecutan sin esperar al programa de la asignatura.

**Objetivo:** en 30–45 días tener una **base general sólida de Java** — suficiente para que cuando Acceso a Datos aborde JDBC, ficheros, XML/JSON y persistencia, no estés atascado en la sintaxis del lenguaje. La parte específica de la asignatura la enseña el profesor: aquí solo se hace un **vistazo de puente** (verla una vez para no ir en blanco), no profundización.

Base metodológica: repo oficial de ejercicios [Exercism Java track](https://github.com/exercism/java) (clonado en `exercism-java/`), equivalente en estructura a Kotlin Koans — cada ejercicio trae un stub y unos tests, se resuelve escribiendo código hasta que el test en verde pasa.

**IDE: IntelliJ IDEA o Android Studio.** Los ejercicios y katas son archivos `.java` normales dentro de un proyecto Java/Gradle plano (no Android): se abren en el editor y se ejecutan con el botón ▶ sobre `main()`.

- **Editor** → archivos de ejercicio (`ejercicios/*.java`) y el mini-proyecto.
- **Run window** → salida de `System.out.println`, igual que la consola en los otros repos.
- **Exercism Java** → cada ejercicio se resuelve dentro de su propio módulo (`exercism-java/exercises/practice/<ejercicio>/`), con tests JUnit que verifican la solución.

## Cómo encaja en 30–45 días

- **Un ejercicio de Exercism por día** es el ritmo base (la lista `exercises/practice/` tiene más de 100 ejercicios progresivos; se elige un subconjunto ordenado por dificultad creciente para las Fases 1–2, dejando el resto como cantera de repaso). Con el margen hasta 45 días quedan días libres para repasar y hacer el puente.
- **El final del plan (semana final) es un vistazo a Acceso a Datos**, con material propio, no con Exercism.

## Reglas de ritmo (lo que da fluidez)

- **Kata diaria (5–10 min)** incluso en días sin sesión: se edita `katas/Katas.java` y se ejecuta `main()` (cada día una kata nueva, sin borrar las anteriores).
- **Leer antes de ejecutar:** predecir la salida antes de correr el código, sobre todo con tipado estático, `null` y excepciones checked — ahí está la diferencia real con Python/Kotlin.
- **Ejercicios obligatorios de Exercism:** se resuelven escribiendo código hasta que el test en verde pasa, no solo leyendo la solución de referencia (`.meta/`).

## Fases

### Fase 1 — Fundamentos (días 1–15, ~15 días)

| Días | Contenido | Foco |
|---|---|---|
| 1–2 | Hello World, variables, tipos primitivos, casting | tipado estático explícito frente a la inferencia de Python/Kotlin |
| 3–4 | Control de flujo (`if`, `switch`, bucles) | `switch` clásico vs `when` de Kotlin; sin `for` sobre rangos nativo |
| 5–6 | Strings, arrays | inmutabilidad de `String`, `StringBuilder`, arrays de tamaño fijo |
| 7–8 | Colecciones (`List`, `Map`, `Set`, Streams básicos) | `Collections`/`Stream` como equivalente a comprehensions de Python |
| 9–10 | Métodos, sobrecarga, paso por valor/referencia | ausencia de funciones top-level: todo vive en una clase |
| 11–12 | Programación orientada a objetos I (clases, constructores, encapsulación) | equivalente a `data class` de Kotlin pero manual (getters/setters, `equals`/`hashCode`) |
| 13–15 | POO II (herencia, interfaces, polimorfismo) | interfaces como contrato — comparar con Kotlin/Python duck typing |

Cierre de fase: repaso de los ejercicios de Exercism resueltos hasta aquí (todos los tests en verde).

### Fase 2 — Robustez y tipos avanzados (días 16–23, ~8 días)

| Días | Contenido | Foco |
|---|---|---|
| 16–17 | Excepciones (`checked` vs `unchecked`, `try`/`catch`/`finally`) | Java obliga a declarar/capturar checked exceptions — no existe en Python/Kotlin |
| 18 | Clases abstractas, `enum` | modelar estados cerrados — comparar con `sealed class` de Kotlin |
| 19–20 | Generics básicos (`<T>`, wildcards) | comparación directa con generics de Kotlin |
| 21 | Lambdas y `Stream` API (introducción) | expresiones lambda, `Function`/`Predicate`, por qué llegaron en Java 8 |
| 22 | Testing con JUnit 5 | equivalente a lo que ya conoces de tests en otros lenguajes |
| 23 | Records (Java 17+) | equivalente directo a `data class` de Kotlin — vistazo, ya sabes el concepto |

Cierre de fase: repaso de excepciones + generics + enums.

### Fase 3 — Puente a Acceso a Datos (días 24–30, ~7 días)

Esto NO es dominar persistencia — es **verlo una vez** para que cuando el profesor lo explique no vayas en blanco. Solo vistazo, sin profundizar (eso lo da el profesor):

| Días | Contenido | Foco |
|---|---|---|
| 24 | **Ficheros y serialización** (`java.io`, `java.nio.file`, `Serializable`) | lectura/escritura de texto y binario, diferencia stream vs bloque |
| 25 | **JDBC — conexión y consultas básicas** | `Connection`, `Statement`/`PreparedStatement`, `ResultSet` |
| 26 | **SQL desde Java** (CRUD con `PreparedStatement`) | parámetros preparados, por qué evitan inyección SQL |
| 27 | **XML desde Java** (parseo mínimo, DOM o JAXB vistazo) | qué opción se usará en clase, comparar con JSON |
| 28 | **JSON desde Java** (una librería vistazo, ej. Jackson o Gson) | serialización de objetos a JSON y viceversa |
| 29 | **ORM básico — vistazo** (idea de JPA/Hibernate, sin montar nada real) | qué problema resuelve un ORM frente a JDBC puro, sin profundizar |
| 30 | Buffer / repaso / quiz final | cerrar repasando excepciones, generics y el flujo JDBC (lo que más se olvida) |

## Qué NO tocar (decisión consciente)

- Hibernate/JPA a fondo, connection pooling, arquitectura de acceso a datos en capas completa → especialización fuera de "base general", se aprende en clase con la base del lenguaje ya puesta.
- Frameworks web (Spring) → fuera de alcance de este repo, no es el objetivo de la asignatura de momento.

## Alinear con el temario real (pendiente de recalibración)

- **El temario/UDs oficial de Acceso a Datos aún no ha llegado.** La Fase 3 queda por defecto con el orden habitual (ficheros → JDBC → SQL → XML/JSON → ORM), que es el natural de la asignatura.
- **Punto de recalibración:** cuando el profesor entregue el temario, se reordenan los días 24–29 de la Fase 3 para que el vistazo caiga justo antes de la semana en que se aborde cada tema en clase.
- Mientras tanto, aviso de recarga: **día 20 de ejecución** (media de Fase 2), pedir/recoger el temario si ya existe, para recalibrar la Fase 3 con margen.

## Cómo usar esto

1. Un ejercicio de Exercism Java por día (o dos si son cortos).
2. Kata diaria en `katas/Katas.java`, incluso en días sin sesión.
3. Cierre de fase: repasar los ejercicios de esa fase hasta que estén todos en verde, sin mirar la solución de referencia.
4. Dudas → aquí, contrastando con la sintaxis equivalente ya conocida (Python/Kotlin, según convenga).
5. Cierre semanal: `notebooklm generate quiz|flashcards` en "Java Learning AI Brain" (fuente: este plan).
