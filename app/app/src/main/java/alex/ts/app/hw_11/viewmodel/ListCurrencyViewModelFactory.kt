package alex.ts.app.hw_11.viewmodel
import alex.ts.app.hw_11.repo.Repository
import androidx.lifecycle.*

class ListCurrencyViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListCurrencyViewModel(
            repository
        ) as T
    }
}