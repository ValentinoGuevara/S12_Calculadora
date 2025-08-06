
# 🧮 Calculadora Persistente con ViewModel - Semana 12

**Desarrollado por:** Valentino Guevara  
**Correo:** [202114033@uns.edu.pe](mailto:202114033@uns.edu.pe)  
**GitHub:** [ValentinoGuevara](https://github.com/ValentinoGuevara)  
**Curso:** Aplicaciones Móviles - Semana 12  

<div align="center">
  <img src="screenshots4/imagen1.jpg" width="200" alt="Vista de la Calculadora">
</div>

## 🛠️ **Tecnologías Utilizadas**

<div align="center">
  <a href="https://developer.android.com/topic/libraries/architecture/viewmodel">
    <img src="https://img.shields.io/badge/ViewModel-3DDC84?style=for-the-badge&logo=android" alt="ViewModel">
  </a>
  <a href="https://developer.android.com/topic/libraries/architecture/livedata">
    <img src="https://img.shields.io/badge/LiveData-00B0FF?style=for-the-badge&logo=android" alt="LiveData">
  </a>
  <a href="https://kotlinlang.org/">
    <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin" alt="Kotlin">
  </a>
  <a href="https://material.io/components">
    <img src="https://img.shields.io/badge/Material_Design-2196F3?style=for-the-badge&logo=material-design" alt="Material Design">
  </a>
  <a href="https://developer.android.com/guide/components/activities/overview">
    <img src="https://img.shields.io/badge/Android_Activities-FF5722?style=for-the-badge&logo=android" alt="Android Activities">
  </a>
</div>

## 🔍 ¿Cómo funciona la aplicación?

Esta aplicación de calculadora fue desarrollada para demostrar el uso de **ViewModel** en la gestión del estado. Permite realizar operaciones matemáticas básicas mientras **mantiene los datos activos** incluso cuando la pantalla rota o la actividad se recrea.

---

### 🏗️ Arquitectura y Flujo

1. **Uso de ViewModel**:
   - Almacena el número actual, operador seleccionado y resultado.
   - Persiste el estado durante cambios de configuración (como rotaciones).
   - Facilita una arquitectura desacoplada entre UI y lógica.

2. **Operaciones soportadas**:
   - ✅ Suma `+`
   - ✅ Resta `-`
   - ✅ Multiplicación `×`
   - ✅ División `÷`
   - ✅ Porcentaje `%`
   - ✅ Borrado de dígito individual y reinicio total

3. **Interfaz Moderna**:
   - Diseño visual inspirado en **Material Design**.
   - Botones grandes, claros y responsivos.
   - Compatible con modo oscuro.

---

### 🌟 Características Destacadas

| Característica | Descripción |
|----------------|-------------|
| 🧠 **ViewModel** | Control del estado lógico sin reinicios al rotar |
| 🧮 **Operaciones básicas** | Soporte completo para cálculos comunes |
| 🎯 **Botones de acción** | "AC", retroceso, igual y punto decimal |
| 🌙 **Tema oscuro** | Visualización cómoda y moderna |
| 🔄 **Estado persistente** | Mantiene resultados y entrada tras rotación |

---

### 📱 Capturas de Pantalla

<div align="center">
  <table>
    <tr>
      <td><img src="screenshots4/imagen1.jpg" width="200" alt="Calculadora - Vista 1"></td>
      <td><img src="screenshots4/imagen2.jpg" width="200" alt="Calculadora - Vista 2"></td>
      <td><img src="screenshots4/imagen3.jpg" width="200" alt="Calculadora - Vista 3"></td>
    </tr>
        <tr>
      <td><img src="screenshots4/imagen4.jpg" width="200" alt="Calculadora - Vista 4"></td>
      <td><img src="screenshots4/imagen5.jpg" width="200" alt="Calculadora - Vista 5"></td>
      <td><img src="screenshots4/imagen6.jpg" width="200" alt="Calculadora - Vista 6"></td>
    </tr>
  </table>
  <p>Interfaz de usuario clara, moderna y funcional</p>
</div>

---

## 🛠️ Implementación Técnica

### 🧩 Uso de ViewModel

```kotlin
class CalculatorViewModel : ViewModel() {
    private var _input = MutableLiveData("0")
    val input: LiveData<String> get() = _input

    fun onNumberClick(number: String) { ... }
    fun onOperatorClick(operator: String) { ... }
    fun onClear() { ... }
    fun onDelete() { ... }
    fun onEqual() { ... }
}
```

### 🧱 Dependencias y Herramientas

| Herramienta | Uso |
|-------------|-----|
| **Android ViewModel** | Persistencia de datos |
| **LiveData** | Observación reactiva en la UI |
| **Kotlin** | Lógica principal |
| **Material Design Components** | UI moderna |

---

## 🚀 ¿Cómo Ejecutarla?

1. Clona el repositorio:  
   ```bash
   git clone https://github.com/ValentinoGuevara/S12_Calculadora_ViewModel.git
   ```

2. Abre en **Android Studio** y espera que sincronice Gradle.

3. Ejecuta la aplicación en tu emulador o dispositivo físico.

---

## 🧩 Posibles Mejoras Futuras

- 🧮 Soporte para operaciones encadenadas (ej. 5 + 6 × 2).
- 🧠 Historial de cálculos realizados.
- 🗂 Tema personalizado para botones y fondo.
- 🗣 Soporte para accesibilidad (TalkBack, haptics, etc.).

---

## 📚 Contexto Académico

Este proyecto fue desarrollado como parte de la **Semana 12** del curso de Aplicaciones Móviles, con el objetivo de aplicar el patrón **MVVM** en aplicaciones Android mediante el uso de **ViewModel**.

---

## 📜 Licencia

**© 2025 - Valentino Guevara**  
Prohibido el uso comercial sin autorización expresa.

<div align="center">
  <img src="screenshots3/app_demo.gif" width="300" alt="Demo Calculadora">
  <p>¡Explora el código y contribuye!</p>
  <a href="https://github.com/ValentinoGuevara/S12_Calculadora_ViewModel">
    <img src="https://img.shields.io/badge/VER_EN_GITHUB-181717?style=for-the-badge&logo=github">
  </a>
</div>
