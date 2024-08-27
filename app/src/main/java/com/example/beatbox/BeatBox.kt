package com.example.beatbox

import android.content.res.AssetManager
import android.util.Log

private const val TAG = "BeatBox"
private const val SOUNDS_FOLDER = "sample_sounds"

class BeatBox(private val assets: AssetManager) {
    val sounds: List<Sound>
    init {
        sounds = loadSounds()
    }


    fun loadSounds():List<Sound> {
        val soundNames: Array<String>
        try {
             soundNames = assets.list(SOUNDS_FOLDER)!!
        } catch (e: Exception) {
            Log.e(TAG, "Could not list assets",e)
            return emptyList()
        }

        val sounds = mutableListof<Sound>()
        soundNames.forEach { filename -> val assetPath = "$SOUNDS_FOLDER/$filename"
        val sound = Sound(assetPath)
            sound.add(sound)
        }
        return sounds
    }
}