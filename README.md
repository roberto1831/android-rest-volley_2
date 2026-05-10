# 📱 Android REST API Client

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![Volley](https://img.shields.io/badge/Volley-HTTP-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Material Design](https://img.shields.io/badge/Material_Design-757575?style=for-the-badge&logo=materialdesign&logoColor=white)

> Continuación del ejercicio RT2 – Aplicación Android en **Java** que implementa operaciones **CRUD completas** contra una API REST usando **Volley**, con mejoras en el manejo de peticiones y respuestas HTTP.

---

## 🎯 Objetivo

Demostrar el consumo avanzado de una API REST desde Android implementando los cuatro métodos HTTP:

| Método | Operación | Endpoint |
|---|---|---|
| `GET` | Obtener datos | `/posts/1` |
| `POST` | Crear registro | `/posts` |
| `PUT` | Actualizar registro | `/posts/1` |
| `DELETE` | Eliminar registro | `/posts/1` |

**API utilizada:** [JSONPlaceholder](https://jsonplaceholder.typicode.com) — API REST de prueba gratuita.



## 🏗️ Arquitectura

```
MainActivity.java
     │
     ├── Métodos REST (GET, POST, PUT, DELETE)
     │         │
     │         ▼
     │   Volley RequestQueue
     │         │
     │         ▼
     │  JSONPlaceholder API
     │
     └── Listeners de respuesta
           ├── Response.Listener   → Toast de éxito
           └── Response.ErrorListener      → Log de error
```

---

## 📁 Estructura del Proyecto

```
Ejercicio_rt3/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/ejercicio_rt3/
│           │   └── MainActivity.java      # Lógica principal + llamadas REST
│           ├── res/
│           │   ├── layout/
│           │   │   └── activity_main.xml  # UI principal
│           │   ├── values/
│           │   │   ├── colors.xml
│           │   │   ├── strings.xml
│           │   │   └── themes.xml
│           │   └── mipmap-*/              # Íconos en múltiples densidades
│           └── AndroidManifest.xml
└── gradle/
    └── libs.versions.toml                 # Catálogo de versiones
```

---

## 🛠️ Dependencias

| Librería | Versión | Uso |
|---|---|---|
| Volley | 1.2.0 | Peticiones HTTP asíncronas |
| AppCompat | 1.7.0 | Compatibilidad hacia atrás |
| Material Design | 1.12.0 | Componentes UI |
| ConstraintLayout | 2.2.0 | Layouts adaptativos |
| JUnit | 4.13.2 | Pruebas unitarias |
| Espresso | 3.6.1 | Pruebas de instrumentación |

---

## ⚙️ Requisitos

- Android Studio Hedgehog o superior
- JDK 8+
- Android Gradle Plugin 8.7.2
- Dispositivo físico o emulador (API 21+)
- Conexión a internet

---

## 🚀 Instalación y Ejecución

### Desde Android Studio

```bash
# 1. Clonar el repositorio
git clone https://github.com/roberto1831/android-rest-volley-rt3.git
cd android-rest-volley-rt3

# 2. Abrir en Android Studio
# File → Open → seleccionar carpeta del proyecto

# 3. Sincronizar Gradle
# Tools → Gradle → Sync Project with Gradle Files

# 4. Ejecutar
# Run → Run 'app' (Shift + F10)
```

### Instalar APK directamente

```
app/build/outputs/apk/debug/app-debug.apk
```

1. Descarga el archivo `app-debug.apk`
2. En tu dispositivo: **Ajustes → Seguridad → Fuentes desconocidas**
3. Instala el APK

---

## 🧪 Pruebas

```bash
# Pruebas unitarias
./gradlew test

# Pruebas de instrumentación
./gradlew connectedAndroidTest
```

---

## 👤 Autor

**Ing. Roberto Toapanta**  
📍 Quito, Ecuador  
🎓 Universidad de las Fuerzas Armadas – ESPE · 7mo Semestre · Programación Avanzada  
🔗 [GitHub](https://github.com/roberto1831) · [LinkedIn](https://linkedin.com/in/roberto1831)

---

## 📄 Licencia

Uso académico / demostrativo.
