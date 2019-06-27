package com.dmitriy.android.nbuexchange.view


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmitriy.android.nbuexchange.App
import com.dmitriy.android.nbuexchange.R
import com.dmitriy.android.nbuexchange.data.Currency
import com.dmitriy.android.nbuexchange.data.room.CurrencyEntity
import com.dmitriy.android.nbuexchange.data.room.ExchangeEntity
import com.dmitriy.android.nbuexchange.managers.MappingManager
import com.dmitriy.android.nbuexchange.presenter.ListPresenterContract
import com.dmitriy.android.nbuexchange.service.NBUApiService
import com.dmitriy.android.nbuexchange.view.adapter.CurrencyListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject


class MainActivity : CoroutineAppCompatActivity(),ItemClickListener,ListPresenterContract.ListView{


    @Inject
    lateinit var presenter:ListPresenterContract.ListPresenter

    private val CURRENCY_DATA = "CURRENCY_DATA"
    private lateinit var  layoutManager : LinearLayoutManager
    private lateinit var adapter : CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.injectActivity(this)
        presenter.setView(this)
        initList()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelableArrayList(CURRENCY_DATA, adapter.currendList)
        super.onSaveInstanceState(outState)
    }

    private fun initList() {
        layoutManager = LinearLayoutManager(this)
        list.layoutManager = layoutManager
        adapter = CurrencyListAdapter()
        list.adapter = adapter
        adapter.setItemClickListener(this)
    }


    override fun setDataInList(listCurrency: ArrayList<CurrencyEntity>) {
        adapter.setCurrencyList(listCurrency)
    }

    override fun onItemClick(currencyId: Int?) {
//        var exchangeEntity: ExchangeEntity?=null
//        val intent = DetailActivity.newIntent(this, exchangeEntity)
//        startActivity(intent)
    }
}

