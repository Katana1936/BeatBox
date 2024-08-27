package com.example.beatbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beatbox.databinding.ActivityMainBinding
import com.example.beatbox.databinding.ListItemSoundBinding
import com.example.beatbox.ui.theme.BeatBoxTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter()
        }
    }
}

private class SoundHolder(private val binding: ListItemSoundBinding):
    RecyclerView.ViewHolder(binding.root){

}

private class SoundAdapter : RecyclerView.Adapter<SoundHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
            layoutInflater,
            R.layout.list_item_sound, parent, false
        )
        return SoundHolder(binding)
    }


    override fun onBindViewHolder(holder: SoundHolder, position: Int) {

    }

    override fun getItemCount() = 0
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeatBoxTheme {
        Greeting("Android")
    }
}
