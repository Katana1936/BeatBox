import android.media.SoundPool

class BeatBox(private val assets: AssetManager) {
    private val soundPool = SoundPool.Builder().setMaxStreams(5).build()
    val sounds: List<Sound>

    init {
        sounds = loadSounds()
    }

    private fun loadSounds(): List<Sound> {
        val soundNames: Array<String>
        try {
            soundNames = assets.list(SOUNDS_FOLDER)!!
        } catch (e: Exception) {
            Log.e(TAG, "Could not list assets", e)
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach { filename ->
            val assetPath = "$SOUNDS_FOLDER/$filename"
            val sound = Sound(assetPath)
            sound.soundId = loadSound(sound)
            sounds.add(sound)
        }
        return sounds
    }

    private fun loadSound(sound: Sound): Int? {
        try {
            val afd = assets.openFd(sound.assetPath)
            return soundPool.load(afd, 1)
        } catch (e: Exception) {
            Log.e(TAG, "Could not load sound ${sound.assetPath}", e)
            return null
        }
    }

    fun play(sound: Sound) {
        sound.soundId?.let {
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }

    fun release() {
        soundPool.release()
    }
}
