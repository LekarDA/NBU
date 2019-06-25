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
import com.dmitriy.android.nbuexchange.service.NBUApiService
import com.dmitriy.android.nbuexchange.view.adapter.CurrencyListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody


class MainActivity : CoroutineAppCompatActivity(),ItemClickListener{


    private val CURRENCY_DATA = "CURRENCY_DATA"
    private lateinit var  layoutManager : LinearLayoutManager
    private lateinit var adapter : CurrencyListAdapter
    private val BASE_URL = "statdirectory/exchange"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        val apiService = NBUApiService.create()
        if (savedInstanceState != null) adapter.setCurrencyList(savedInstanceState.getParcelableArrayList(CURRENCY_DATA))
        else {
            launch {
                try {
                    val response = apiService.getCurrentCurrency(baseUrl = BASE_URL, value = "")
                    if (response.isSuccessful) this@MainActivity.onResponse(response.body()!!)
                    else this@MainActivity.onFailure(response.errorBody())
                } catch (e: Exception) {
                    Log.i("ExchangeApp", "exception" + e.toString())
                }
            }
        }
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


    fun onFailure(error: ResponseBody?) {
        Log.i("ExchangeApp","error" + error?.string())
    }

    fun onResponse(data:List<Currency>) {
        launch {
            val mappingManager = MappingManager()
            for(currency in data){
                mappingManager.mapping(currency)
            }
            for(entity in mappingManager.listCurrencyEntity){
                App.instance.dataBase?.exchangeDao()?.insertCurrency(entity)
            }
            for (entity in mappingManager.listExchangeEntity){
                App.instance.dataBase?.exchangeDao()?.insertExchange(entity)
            }
        }
        var listCurrencyEntityFromDB = ArrayList<CurrencyEntity>()
        launch {
            async(Dispatchers.IO) {
                listCurrencyEntityFromDB = App.instance.dataBase?.exchangeDao()?.getAll() as ArrayList<CurrencyEntity>
            }.await()
        }

        adapter.setCurrencyList(listCurrencyEntityFromDB)
    }

    override fun onItemClick(currencyId: Int?) {
        var exchangeEntity: ExchangeEntity?=null
        launch {
            async(Dispatchers.IO) {
                exchangeEntity = App.instance.dataBase?.exchangeDao()?.getExchangeById(currencyId?.toLong())
            }.await()
        }

        val intent = DetailActivity.newIntent(this, exchangeEntity)
        startActivity(intent)
    }
}

