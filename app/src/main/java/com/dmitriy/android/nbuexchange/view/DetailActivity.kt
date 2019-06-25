package com.dmitriy.android.nbuexchange.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmitriy.android.nbuexchange.R
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import kotlinx.android.synthetic.main.detail_currency.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_currency)
        val exchange = intent.getParcelableExtra<ExchangeEntity>(EXCHANGE_ITEM)
        dateValue.text = exchange.exchangeDate
        currentValue.text = exchange.rate.toString()
        codeValue.text = exchange.id.toString()
    }

    companion object {
        private val EXCHANGE_ITEM = "EXCHANGE_ITEM"

        fun newIntent(context: Context, exchangeEntity: ExchangeEntity?): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXCHANGE_ITEM, exchangeEntity)
            return intent
        }
    }
}