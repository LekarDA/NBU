package com.dmitriy.android.nbuexchange.view


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmitriy.android.nbuexchange.App
import com.dmitriy.android.nbuexchange.R
import com.dmitriy.android.nbuexchange.presenter.ListPresenterContract
import com.dmitriy.android.nbuexchange.view.adapter.CurrencyListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : CoroutineAppCompatActivity(), ItemClickListener, ListPresenterContract.ListView{



    @Inject
    lateinit var presenter: ListPresenterContract.ListPresenter

    private val CURRENCY_DATA = "CURRENCY_DATA"
    private lateinit var  layoutManager : LinearLayoutManager
    private lateinit var adapter : CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.injectActivity(this)
        presenter.setView(this)
        initList()
        if(savedInstanceState == null)
            launch { adapter.setCurrencyList(presenter.getData()) }
        else adapter.setCurrencyList(savedInstanceState.getParcelableArrayList(CURRENCY_DATA))

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


    override fun onItemClick(currencyId: Int?) {
        launch {
            val intent = DetailActivity.newIntent(this@MainActivity, presenter.getExchangeEntity(currencyId?.toLong()))
            startActivity(intent)
        }
    }
}

