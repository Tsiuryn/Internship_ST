package alex.ts.app.hw_08.task_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import alex.ts.app.R
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.my_counter_fragment.*

class MyCounterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_counter_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vm : MyCounterViewModel by activityViewModels<MyCounterViewModel>()
        vm.number.observe(this, androidx.lifecycle.Observer{
            hw8TvFragmentCounter.text = it.toString()
        })
    }


}