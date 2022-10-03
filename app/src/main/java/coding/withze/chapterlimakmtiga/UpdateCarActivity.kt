package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coding.withze.chapterlimakmtiga.databinding.ActivityUpdateCarBinding

class UpdateCarActivity : AppCompatActivity() {

    lateinit var binding : ActivityUpdateCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCarBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}