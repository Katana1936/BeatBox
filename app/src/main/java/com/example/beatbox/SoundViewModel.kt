package com.example.beatbox

class SoundViewModel(private val beatBox: BeatBox) {
    var sound: Sound? = null
        set(sound) {
            field = sound
        }

    val title: String?
        get() = sound?.name

    fun playSound() {
        sound?.let {
            beatBox.play(it)
        }
    }
}
