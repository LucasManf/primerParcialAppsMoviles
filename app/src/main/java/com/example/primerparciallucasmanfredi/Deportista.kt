package com.example.primerparciallucasmanfredi

data class Deportista (
    val id: Int,
    val nombre: String,
    val deporte: Deporte,
    val pais: Pais,
    val activo: Boolean
)

enum class Deporte {
    FUTBOL,
    BASQUETBOL,
    TENIS,
    HOCKEY,
    CICLISMO,
    ATLETISMO,
    BMX,
    VOLEIBOL,
    JUDO,
    GIMNASIA,
    AUTOMOVILISMO
}

enum class Pais {
    ARGENTINA,
    URUGUAY,
    COLOMBIA,
    CHILE,
    BRASIL
}