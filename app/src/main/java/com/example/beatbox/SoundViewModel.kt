package com.example.beatbox


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.beatbox.BR
import com.example.beatbox.Sound

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {

    var sound: Sound? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    val title: String?
        get() = sound?.name

    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }
}
