package alex.ts.app.hw_11

import alex.ts.app.R
import alex.ts.app.hw_11.adapter.CurrencyAdapter
import alex.ts.app.hw_11.model.Currency
import alex.ts.app.hw_11.repo.Repository
import alex.ts.app.hw_11.viewmodel.ListCurrencyViewModel
import alex.ts.app.hw_11.viewmodel.ListCurrencyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_the_eleventh.*
import kotlin.collections.ArrayList

class TheEleventhActivity : AppCompatActivity() {

    private lateinit var adapter: CurrencyAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_eleventh)
        setSupportActionBar(hw11Toolbar)
        recycler = hw11Recycler
        val vm = ViewModelProvider(this, ListCurrencyViewModelFactory(Repository(applicationContext)))
            .get(ListCurrencyViewModel::class.java)
        vm.listCurrency.observe(this, Observer {
            createAdapter(it)
        })

    }

    private fun createAdapter (list: List<Currency>){
        adapter = CurrencyAdapter(list as ArrayList<Currency>)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.my_menu, menu)

        val searchItem = menu!!.findItem(R.id.hw11Search)
        val searchView = searchItem.actionView as android.widget.SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
        return true
    }
}