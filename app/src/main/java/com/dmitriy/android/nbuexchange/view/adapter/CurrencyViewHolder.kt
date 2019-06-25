package com.dmitriy.android.nbuexchange.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import kotlinx.android.synthetic.main.currency_item.view.*

class CurrencyViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView)/*, View.OnClickListener*/ {

    private var view: View = containerView

    fun setData(currency: CurrencyEntity) {
        view.title.text = currency.name
        view.code.text = currency.code
    }

}