# Acceso a Datos · Repaso semana 19-25 oct 2026

Examen: **25 nov 2026** (práctico en Eclipse + teórico en Moodle). Fechas por confirmar con el profesor.

## Objetivo de la semana

Interiorizar la **estructura por capas** (modelo, DAO, interfaz) y el **molde de un método DAO**, de modo que puedas escribirlo sin mirar.

## Molde de un método DAO

1. Escribir el SQL con `?` donde van los datos.
2. Abrir la conexión y preparar el `PreparedStatement` (`try-with-resources`).
3. Rellenar los `?` con `setString(1, ...)`, `setInt(2, ...)`. La numeración empieza en 1.
4. Ejecutar:
   - `executeQuery()` para `SELECT`: recorrer con `while (rs.next())` y construir un objeto por fila.
   - `executeUpdate()` para `INSERT`, `UPDATE` y `DELETE`: devuelve filas afectadas; `> 0` indica éxito.
5. No capturar `SQLException` en el DAO: declarar `throws SQLException` y dejar que la capa que llama (`Main`, `GestorFicheros`) decida qué mostrar. Decisión tomada: los DAOs propagan la excepción.

## Tareas (45 min cada una, sin mirar, cronometradas)

- [x] **Martes (hecho el 20 oct):** proyecto vacío en Eclipse con `Tarea` (id, titulo, hecha), `TareaDAO` (`crearTabla`, `insertar`, `listarTodos`, `eliminar`) y `Main` con menú. Dominio distinto al de productos para forzar el molde. Enunciado completo en [`ENUNCIADO_gestorTareas.md`](ENUNCIADO_gestorTareas.md). **Tiempo: 64 min (10:12 a 11:16), con revisión incluida.** Meta para repetirlo: menos de 45 min y sin vueltas de revisión en los 4 puntos que fallaron (`CREATE TABLE`, `mapear` con id, `return` de `listarTodos`, variable del menú).
- [x] **Miércoles (hecho el 21 oct):** variante `AppS34` del reto s33 (productos y precios con `BufferedReader` y `BufferedWriter`). Enunciado en `AppS34/ENUNCIADO_AppS34.md`. **Tiempo: 83 min (10:20 a 11:43), con revisión incluida.** Fallos a evitar al repetirlo: asignar `readLine()` dentro del `while`, validar la línea antes de `parseDouble`, número de campos correcto, no añadir el producto en cada ejecución, mismo formato en consola y fichero. Pendiente: `.trim()` en la respuesta S/N y probar el camino `s`.
- [ ] **Sábado:** repetir "sin mirar" el volcado de `TareaDAO.listarTodos()` a un `.txt` con `BufferedWriter` y su lectura con `BufferedReader` (es repaso de `GestorFicheros`, aplicado al dominio de Tarea). La novedad (JSON y serialización) va en la semana 26-30 oct.
- [ ] Revisar y commitear los arreglos del análisis de los repos (`jdbc-sqlite` y `AccesoADatos`). `GestorFicheros` ya está commiteado (f1cc6b7).

## Teoría: puntos donde ya has fallado en Moodle

- `executeQuery()` sirve para `SELECT`; `executeUpdate()` para `INSERT`, `UPDATE` y `DELETE`.
- Orden de un acceso JDBC: abrir conexión, preparar el `PreparedStatement`, ejecutar, leer el `ResultSet`.
- `File.exists()` para comprobar si existe un fichero.
- `read()` devuelve `-1` al final; `readLine()` devuelve `null`.

## Pendiente (no urgente)

- `UD2. Persistencia avanzada` aún vacía en Moodle (revisar la semana 26-30 oct).
- Tarea de teoría de Moodle: vence el **20 nov**.

## Semana 26-30 oct (huecos de cobertura, tareas fijas)

- [ ] **Serialización, JSON y XML** (libro 02 de UD1): sin ninguna práctica en los repos. Ejercicio: guardar y leer la lista de `Tarea` como objeto serializado y como JSON.
- [ ] **Transacciones**: `setAutoCommit(false)`, `commit()` y `rollback()` con una operación de varias sentencias.
- [ ] **JOIN**: una consulta con dos tablas relacionadas mapeada a objetos.
