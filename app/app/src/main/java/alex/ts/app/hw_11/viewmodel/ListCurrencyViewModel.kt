package alex.ts.app.hw_11.viewmodel

import alex.ts.app.hw_11.model.Currency
import alex.ts.app.hw_11.repo.Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ListCurrencyViewModel(repository: Repository): ViewModel() {

    private var _listCurrency = MutableLiveData<List<Currency>>()
    val listCurrency: LiveData<List<Currency>> = _listCurrency
    init {
        viewModelScope.launch {
            _listCurrency.value = repository.getPost()

        }
    }
}