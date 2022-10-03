package coding.withze.chapterlimakmtiga.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coding.withze.chapterlimakmtiga.model.DataCar
import coding.withze.chapterlimakmtiga.model.PostResponseCar
import coding.withze.chapterlimakmtiga.model.PutResponseCar
import coding.withze.chapterlimakmtiga.model.ResponseDataCarItem
import coding.withze.chapterlimakmtiga.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel() {

    lateinit var liveDataCar: MutableLiveData<List<ResponseDataCarItem>>
    lateinit var postLDCar : MutableLiveData<PostResponseCar>
    lateinit var putLDCar : MutableLiveData<List<PutResponseCar>>

    init {
        liveDataCar = MutableLiveData()
        postLDCar = MutableLiveData()
        putLDCar = MutableLiveData()
    }

    fun getLiveDataCa() : MutableLiveData<List<ResponseDataCarItem>>{
        return liveDataCar
    }

    fun postLiveDataCar() : MutableLiveData<PostResponseCar>{
        return postLDCar
    }

    fun putLiveDataCar() : MutableLiveData<List<PutResponseCar>>{
        return putLDCar
    }

    fun callUpdateApiCar(id : Int, name: String, category: String, price: Int, status: Boolean, image: String){
        RetrofitClient.instance.updateDataCar(id, DataCar(name, category, price, status, image))
            .enqueue(object : Callback<List<PutResponseCar>>{
                override fun onResponse(
                    call: Call<List<PutResponseCar>>,
                    response: Response<List<PutResponseCar>>
                ) {
                    if (response.isSuccessful){
                        putLDCar.postValue(response.body())
                    } else{
                        putLDCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<PutResponseCar>>, t: Throwable) {
                    putLDCar.postValue(null)
                }

            })
    }

    fun callPostApiCar(name: String, category: String, price: Int, status: Boolean, image: String) {
        RetrofitClient.instance.addDataCar(DataCar(name, category, price, status, image))
            .enqueue(object : Callback<PostResponseCar>{
                override fun onResponse(
                    call: Call<PostResponseCar>,
                    response: Response<PostResponseCar>
                ) {
                    if (response.isSuccessful){
                        postLDCar.postValue(response.body())
                    } else{
                        postLDCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<PostResponseCar>, t: Throwable) {
                    postLDCar.postValue(null)
                }

            })
    }

    fun callApiCar(){
        RetrofitClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    } else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}