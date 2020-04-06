package com.daniel.farre.yogasolotest.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.farre.yogasolotest.R
import com.daniel.farre.yogasolotest.domain.Posture
import com.daniel.farre.yogasolotest.presentation.GlobalConstants.Companion.ID_EXTRAS
import com.daniel.farre.yogasolotest.presentation.detail.PostureDetailActivity
import com.daniel.farre.yogasolotest.presentation.koinPosturesModule
import kotlinx.android.synthetic.main.posture_list_fragment.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class PosturesFragment : Fragment(R.layout.posture_list_fragment), PosturesListener {

    private val viewModel: PosturesViewModel by inject()
    private val adapter = PosturesAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(koinPosturesModule)
        postures_list.adapter = adapter
        postures_list.layoutManager = LinearLayoutManager(context)
        viewModel.postures.observe(viewLifecycleOwner, Observer {
            adapter.posturesList = it
            adapter.notifyDataSetChanged()
        })
        viewModel.getPostures()
    }

    override fun onClicked(posture: Posture) {
        val intent = Intent(context, PostureDetailActivity::class.java)
        intent.putExtra(ID_EXTRAS, posture.id)
        startActivity(intent)
    }

}
