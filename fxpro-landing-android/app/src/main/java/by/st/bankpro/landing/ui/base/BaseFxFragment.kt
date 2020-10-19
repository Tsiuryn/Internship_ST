package by.st.bankpro.landing.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFxFragment<T : ViewModel> : Fragment() {
    protected abstract val viewModel: T
}