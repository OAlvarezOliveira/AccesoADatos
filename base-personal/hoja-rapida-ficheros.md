# Hoja rápida: ficheros en Java (`java.nio.file`)

## 1. Qué opciones poner en `Files.writeString` / `Files.write`

| Quiero... | Opciones |
|---|---|
| Crear o **sobrescribir** todo (vaciar antes) | sin opciones, o `CREATE` + `TRUNCATE_EXISTING` |
| **Añadir** al final y crear si no existe | `CREATE` + `APPEND` |
| Añadir al final, el fichero **debe existir** | `APPEND` |
| Crear solo si **no existe** (falla si existe) | `CREATE_NEW` |

Trampas comprobadas:

- `CREATE` **solo**, sobre un fichero existente, NO vacía: escribe encima desde el principio y deja restos del contenido anterior.
- `APPEND` **solo**, sobre un fichero que no existe, lanza `NoSuchFileException`.
- Sin ninguna opción equivale a `CREATE` + `TRUNCATE_EXISTING` + `WRITE`.
- Nunca mezclar `APPEND` con `TRUNCATE_EXISTING`.

```java
Path ruta = Path.of("src/paquete/datos.txt");

// sobrescribir
Files.writeString(ruta, texto);

// añadir (crea si no existe)
Files.writeString(ruta, linea + "\n",
        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
```

## 2. Leer

```java
String todo = Files.readString(ruta);            // todo el fichero en un String
List<String> lineas = Files.readAllLines(ruta);  // una String por línea
for (String l : lineas) { ... }
```

Todos lanzan `IOException`: o `throws IOException` en el método, o `try/catch`.

Con `Scanner` (línea a línea):

```java
try (Scanner sc = new Scanner(new File(ruta))) {
    while (sc.hasNextLine()) {
        String linea = sc.nextLine().trim();
    }
}
```

## 3. Escribir muchas líneas

```java
StringBuilder sb = new StringBuilder();
for (Alumno a : lista) {
    sb.append(a.getNombre()).append(";").append(a.getNota()).append("\n");
}
Files.writeString(ruta, sb);   // una sola escritura, fuera del bucle
```

No llamar a `writeString` dentro del bucle con `TRUNCATE_EXISTING`: cada vuelta borra lo anterior.

## 4. Procesar una línea `nombre;nota`

```java
String[] partes = linea.split(";");
if (partes.length != 2) { /* línea malformada */ continue; }
try {
    String nombre = partes[0].trim();
    int marca = Integer.parseInt(partes[1].trim());
} catch (NumberFormatException e) { /* dato no numérico */ }
```

Comprobar en este orden: línea vacía, número de campos, conversión a número, rango (por ejemplo, negativos).

## 5. Utilidades de `Files` / `Path`

```java
Files.exists(ruta)               Files.notExists(ruta)
Files.createDirectories(dir)     Files.deleteIfExists(ruta)
Files.size(ruta)                 ruta.getFileName()
```

## 6. Errores típicos con `Scanner(System.in)`

- Después de `nextInt()` o `nextDouble()`, añadir `sc.nextLine()` para consumir el salto de línea. Si no, el siguiente `nextLine()` devuelve vacío.
- Usar **un solo** `Scanner(System.in)` en todo el programa.
- Comparar texto sin importar mayúsculas: `equalsIgnoreCase(...)` o `.trim().toUpperCase()` antes de comparar. `"Suspenso"` no es igual a `"SUSPENSO"`.
- Enum desde texto: `TipoX.valueOf(txt.trim().toUpperCase())` dentro de `try/catch (IllegalArgumentException e)`.

## 7. Formato

| Quiero | Uso |
|---|---|
| entero | `%d` (no `d%`) |
| decimal 2 cifras | `%.2f` |
| salto de línea en `printf` / `String.format` | `%n` |

## 8. Plantilla mínima de un ejercicio de ficheros

```java
public static void main(String[] args) throws IOException {
    Path ruta = Path.of("src/paquete/datos.txt");
    // 1. leer y validar (apartado 4)
    // 2. calcular con colecciones (HashMap<String, ArrayList<Integer>>)
    // 3. escribir resultado (apartados 1 y 3)
}
```
