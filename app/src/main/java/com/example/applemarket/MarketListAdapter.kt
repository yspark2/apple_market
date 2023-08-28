package com.example.applemarket

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.MarketItemListBinding
import java.text.DecimalFormat

class MarketListAdapter(val items: MutableList<MarketItems>) :
    RecyclerView.Adapter<MarketListAdapter.Holder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketListAdapter.Holder {
        val binding =
            MarketItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder((binding))
    }

    private val list = ArrayList<MarketItems>()

    override fun onBindViewHolder(holder: MarketListAdapter.Holder, position: Int) {
        holder.itemView.setOnClickListener { // 클릭 이벤트 추가 부분
            itemClick?.onClick(it, position)
        }
        holder.img.setImageResource(items[position].img)
        holder.title.text = items[position].title
        holder.addr.text = items[position].addr
        val decimalFormat = DecimalFormat("#,###")
        holder.price.text = decimalFormat.format(items[position].price) + "원"
        holder.chat.text = items[position].chat.toString()
        holder.good.text = items[position].good.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class Holder(val binding: MarketItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.marketItemIvIcon
        val title = binding.marketItemTvTitle
        val addr = binding.marketItemTvAddr
        val price = binding.marketItemTvPrice
        val chat = binding.marketItemTvChat
        val good = binding.marketItemTvGood
    }
}