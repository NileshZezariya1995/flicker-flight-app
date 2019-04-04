package id.djaka.flicker.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.djaka.flicker.R
import id.djaka.mvpanddagger.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : BaseFragment<HomePresenter>(), HomeView {
    override fun instantiatePresenter(): HomePresenter {
        return HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        presenter.onViewDestroyed()

        prepareButtonAction(v)
        return v
    }

    private fun prepareButtonAction(v:View) {
        v.btn_search.setOnClickListener { presenter.launchSearchActivity(context) }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}