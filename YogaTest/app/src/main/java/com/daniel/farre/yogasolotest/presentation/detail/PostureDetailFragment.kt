package com.daniel.farre.yogasolotest.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.daniel.farre.yogasolotest.R
import com.daniel.farre.yogasolotest.domain.Posture
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.posture_detail_fragment.*
import org.koin.android.ext.android.inject

class PostureDetailFragment(val id: String) : Fragment(R.layout.posture_detail_fragment) {

    private val viewModel: PostureDetailViewModel by inject()
    private var posture: Posture = Posture()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.posture.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            posture = it
            updateUI()
        })
        viewModel.getPostureDetail(id)
    }

    private fun updateUI() {
        name_position.text = posture.name
        duration_position.text = posture.duration
        teacher_position.text = posture.teacher
        description_position.text = posture.description
        Picasso.with(row_image.context).load(posture.picture).skipCache().into(row_image)
    }
}
