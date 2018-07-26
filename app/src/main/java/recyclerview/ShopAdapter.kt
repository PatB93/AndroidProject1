package recyclerview

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pbode.dndshopgenerator.R
import com.example.pbode.dndshopgenerator.databinding.ComponentShopItemBinding
import userintent.ShopItemIntent


class ShopAdapter(private val userIntentList: List<ShopItemIntent>) : Adapter<ShopItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShopItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = ComponentShopItemBinding.inflate(layoutInflater, parent, false)
        return ShopItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userIntentList.size
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder?, position: Int) {
        val userIntent = userIntentList[position]
        holder?.bind(userIntent)
    }

    override fun getItemViewType(position: Int) = R.layout.component_shop_item
}

class ShopItemViewHolder(private val binding: ComponentShopItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userIntent: ShopItemIntent) {
        binding.userIntent = userIntent
        binding.executePendingBindings()
    }
}