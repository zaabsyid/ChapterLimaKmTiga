package coding.withze.chapterlimakmtiga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coding.withze.chapterlimakmtiga.databinding.ItemCarBinding
import coding.withze.chapterlimakmtiga.model.ResponseDataCarItem
import com.bumptech.glide.Glide

class CarAdapter(var listCar : List<ResponseDataCarItem>):RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemCarBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.binding.nameCar.text = listCar[position].name
        holder.binding.categoryCar.text = listCar[position].category
        holder.binding.priceCar.text = listCar[position].price.toString()
        Glide.with(holder.itemView).load(listCar[position].image).into(holder.binding.imgCar)

        holder.binding.cvCar.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}