package com.dmitriy.android.nbuexchange.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmitriy.android.nbuexchange.R
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.listen
import com.dmitriy.android.nbuexchange.view.ItemClickListener

class CurrencyListAdapter : RecyclerView.Adapter<CurrencyViewHolder>() {

    var currendList: ArrayList<CurrencyEntity>? = ArrayList()
    private lateinit var listener: ItemClickListener

    fun setCurrencyList(listOfCurrency: ArrayList<CurrencyEntity>){
        currendList?.clear()
        currendList?.addAll(listOfCurrency)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.currency_item,parent,false)
        return CurrencyViewHolder(view).listen { position, type ->
            val item = currendList?.get(position)
            listener.onItemClick(item?.id)
        }
    }

    override fun getItemCount(): Int {
        return currendList?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: CurrencyViewHolder, position: Int) {
        currendList?.get(position)?.let { viewHolder.setData(it) }
    }

    fun setItemClickListener(listener:ItemClickListener){
        this.listener = listener
    }
}