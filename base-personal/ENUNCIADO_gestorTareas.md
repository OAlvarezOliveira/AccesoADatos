# Enunciado: Gestor de tareas (JDBC + SQLite)

**Tiempo objetivo:** 45 minutos, sin mirar apuntes ni código anterior.
**Referencia:** martes 20 oct 2026, 64 minutos con revisión incluida.

## 1. Objetivo

Aplicación de consola que gestiona una lista de tareas guardada en una base de datos SQLite, con la estructura por capas: modelo, DAO e interfaz (menú).

## 2. Preparación

- Proyecto Java en Eclipse con el driver `sqlite-jdbc` en el classpath.
- Paquete `gestorTareas` con tres clases: `Tarea`, `TareaDAO` y `Main`.
- Base de datos: `jdbc:sqlite:tareas.db`, en la raíz del proyecto. Se crea sola al conectar.

## 3. Modelo: `Tarea`

Atributos, todos `private`:

| Atributo | Tipo | Observación |
|----------|------|-------------|
| `id` | `int` | Lo genera la base de datos, no el programa |
| `titulo` | `String` | Obligatorio |
| `hecha` | `boolean` | `false` = pendiente |

Debe tener:

1. Constructor `Tarea(String titulo, boolean hecha)` para una tarea nueva, sin id todavía.
2. Constructor `Tarea(int id, String titulo, boolean hecha)` para reconstruir una tarea leída de la base de datos. **Debe asignar los tres atributos, incluido el id.**
3. Getters y setters.
4. `toString()` con el formato `Tarea [id=1, titulo=Comprar pan, hecha=false]`.

## 4. Capa de datos: `TareaDAO`

Reglas generales:

- Todos los métodos son `static` y declaran `throws SQLException`. **El DAO no captura ni imprime excepciones**: lo hace quien lo llama.
- La URL y cada sentencia SQL son constantes `private static final` al principio de la clase.
- Cada método abre `Connection` y `PreparedStatement` en un `try-with-resources`. Los valores se pasan siempre con `?`, nunca concatenados.
- Los `?` se numeran desde 1.

### Tabla `tarea`

| Columna | Tipo SQLite | Restricciones |
|---------|-------------|---------------|
| `id` | `INTEGER` | `PRIMARY KEY AUTOINCREMENT` |
| `titulo` | `TEXT` | `NOT NULL` |
| `hecha` | `INTEGER` | `NOT NULL` (0 = pendiente, 1 = hecha) |

SQLite no tiene tipo booleano: `setBoolean` y `getBoolean` del driver convierten a 0 y 1.

### Métodos

| Método | Qué hace | Devuelve |
|--------|----------|----------|
| `crearTabla()` | `CREATE TABLE IF NOT EXISTS tarea(...)`. Se puede llamar varias veces sin error | `void` |
| `insertar(Tarea t)` | `INSERT` de `titulo` y `hecha`. **El `INSERT` no incluye `id`** | `void` |
| `listarTodos()` | `SELECT * FROM tarea ORDER BY titulo`. Recorre con `while (rs.next())` y construye cada objeto con un método privado `mapear(ResultSet)` | `ArrayList<Tarea>` |
| `eliminar(int id)` | `DELETE ... WHERE id = ?` | `boolean`: `true` si borró alguna fila (`executeUpdate() > 0`) |

Detalles que exige el examen:

- `executeQuery()` para `SELECT`; `executeUpdate()` para `CREATE`, `INSERT` y `DELETE`.
- El `ResultSet` se cierra también en un `try-with-resources`.
- `mapear` usa el constructor de tres parámetros y lee el id con `rs.getInt("id")`.
- `listarTodos` devuelve la lista **al final** del método, fuera del `try`.

## 5. Interfaz: `Main`

Menú de consola que se repite hasta elegir salir:

```
1. Insertar tarea
2. Listar todas
3. Eliminar tarea
0. Salir
Elige una opcion
```

Comportamiento:

- Al arrancar, llama a `crearTabla()`. Si lanza `SQLException`, muestra `No se pudo crear la tabla: ` más el mensaje del error.
- **Opción 1:** pide el título y el estado (`true`/`false`), crea la `Tarea` e inserta. Éxito: `Tarea insertada`.
- **Opción 2:** recorre la lista e imprime cada tarea con su `toString`.
- **Opción 3:** pide el id. Si se borró algo: `Tarea eliminada`; si no: `Tarea no eliminada`.
- **Opción 0:** `Fin de programa`.
- Cualquier otro número: `Opcion no valida`.

Reglas de lectura y errores:

- Se lee **todo con `sc.nextLine()`** y se convierte después (`Integer.parseInt`, `Boolean.parseBoolean`). No se usa `nextInt()` ni `nextBoolean()`, porque dejan el salto de línea en el buffer y rompen el siguiente `nextLine()`.
- Cada llamada al DAO va en su `try/catch (SQLException e)`, y muestra un mensaje que diga qué falló.
- Si se escribe texto donde va un número, se captura `NumberFormatException`, se avisa y **el menú vuelve a mostrarse**. El programa no termina ni repite la acción anterior.
- La variable del menú es **local** a `main` y se inicializa a `-1`, no a 0, para que un primer valor inválido no cierre el programa.

## 6. Pruebas manuales que debe pasar

1. Insertar dos tareas y listar: salen con id 1 y 2, en orden alfabético de título.
2. Cerrar el programa, abrirlo y listar: las tareas siguen ahí.
3. Eliminar el id 1 y listar: solo queda la 2.
4. Eliminar un id que no existe: `Tarea no eliminada`.
5. Escribir `abc` como primera opción del menú: avisa y vuelve a mostrar el menú.
6. Escribir `zz` como id en la opción 3: avisa y vuelve al menú.
7. Tras insertar una tarea, elegir otra opción: no debe pedir los datos otra vez.

## 7. Criterios de corrección

- Compila y las 7 pruebas pasan.
- El modelo, el DAO y el menú están en clases separadas.
- El DAO no imprime nada ni captura excepciones.
- Ningún recurso JDBC queda sin cerrar.

## 8. Errores que ya salieron (comprobar antes de entregar)

| Error | Qué provoca |
|-------|-------------|
| `CREATE TABLE` sin nombre de tabla, sin paréntesis o con un `WHERE` | `SQLException` al arrancar |
| `mapear` con el constructor de 2 parámetros | Todos los ids salen como 0 y `eliminar` no sirve |
| Constructor de 3 parámetros sin `this.id = id` | Igual que el anterior, y compila sin avisar |
| `listarTodos` sin `return lista` o de tipo `void` | El resultado se pierde |
| `ORDER BY` por una columna que no existe | `SQLException` al listar |
| Variable del menú a 0 o como campo estático | Un valor inválido cierra el programa o repite la acción anterior |
| `nextInt()` / `nextBoolean()` mezclados con `nextLine()` | El menú siguiente lee una cadena vacía |
