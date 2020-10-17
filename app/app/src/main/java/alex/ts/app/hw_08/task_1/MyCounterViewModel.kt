package alex.ts.app.hw_08.task_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCounterViewModel : ViewModel() {
    private val mutableNumber = MutableLiveData<Int>()
    val number: LiveData<Int> = mutableNumber

    fun sendNumberToFragment (number: Int){
        mutableNumber.value = number
    }
}