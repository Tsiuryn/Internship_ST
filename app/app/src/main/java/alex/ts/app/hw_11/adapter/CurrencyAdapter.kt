package alex.ts.app.hw_11.adapter
import alex.ts.app.R
import alex.ts.app.hw_11.model.Currency
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_currency.view.*
import java.util.*
import kotlin.collections.ArrayList

class CurrencyAdapter(private val list: ArrayList<Currency>) :
    RecyclerView.Adapter<CurrencyAdapter.Holder>(), Filterable {
    var itemFilterList = ArrayList<Currency>()
    init {
        itemFilterList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val currencyList = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent,false)
        val myHolder = Holder(currencyList)
        return myHolder
    }

    override fun getItemCount(): Int = itemFilterList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currency = itemFilterList[position]
        holder.abbrev.text = currency.curAbbreviation
        holder.date.text = changeDate(currency.date)
        holder.name.text = currency.curName
        holder.rate.text = currency.curOfficialRate.toString()
        holder.scale.text = "/" + currency.curScale

    }

    private fun changeDate(date: String):String{
        return date.substring(0, 10)
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val date = view.hw11Date
        val abbrev = view.hw11Abbreviation
        val name = view.hw11Name
        val rate = view.hw11Rate
        val scale = view.hw11Scale
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSeach = constraint.toString()
                if(charSeach.isEmpty()){
                    itemFilterList = list
                }else{
                    val resultList = ArrayList<Currency>()
                    for (item in list){
                        if(item.curAbbreviation.toLowerCase(Locale.ROOT)
                                .contains(charSeach.toLowerCase(Locale.ROOT))){
                            resultList.add(item)
                        }
                    }
                    itemFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = itemFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemFilterList = results?.values as ArrayList<Currency>
                notifyDataSetChanged()
            }
        }
    }

}