package cl.gencina.perritosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gencina.perritosapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)    }
}