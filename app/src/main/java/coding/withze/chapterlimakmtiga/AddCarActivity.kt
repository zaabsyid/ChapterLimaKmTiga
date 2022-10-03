package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import coding.withze.chapterlimakmtiga.databinding.ActivityAddCarBinding
import coding.withze.chapterlimakmtiga.viewmodel.ViewModelCar

class AddCarActivity : AppCompatActivity() {

    lateinit var binding : ActivityAddCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddCar.setOnClickListener {
            var edtName = binding.name.text.toString()
            var edtCategory = binding.category.text.toString()
            var edtPrice = binding.price.text.toString()
            var edtStatus = binding.status.text.toString()
            var edtImage = binding.image.text.toString()
            addCar(edtName, edtCategory, edtPrice.toInt(), edtStatus.toBoolean(), edtImage)
        }
    }

    fun addCar(name : String, category : String, price : Int, status : Boolean, image : String){
        var viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callPostApiCar(name, category, price, status, image)
        viewModel.postLiveDataCar().observe(this, Observer {
            if (it != null){
                Toast.makeText(this, "Add Data Suscess", Toast.LENGTH_SHORT).show()
            }
        })
    }
}