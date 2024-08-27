package com.example.beatbox

private const val   WAV = ".wav"

class Sound(val assetPath: String) {
    val name = assetPath.split("/").last().removeSuffix(WAV)
}
// В конструкторе выполняется небольшая подготовительная работа для генерации удобочитаемого имени звука. Сначала имя файла отделяется вызовом String.split(String).last(), после чего вызов String.removeSuffix(String) удаляет расширение.
