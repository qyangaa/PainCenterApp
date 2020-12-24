package com.example.paincenterapp.ui.track

import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.paincenterapp.R
import com.example.paincenterapp.ui.utils.PinView


class TrackFragment : Fragment() {

    private lateinit var trackViewModel: TrackViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trackViewModel =
                ViewModelProvider(this).get(TrackViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_track, container, false)

        val anatomyView = root.findViewById<PinView>(R.id.anatomyView)
        anatomyView.setImage(ImageSource.resource(R.drawable.anatomy_back));
        anatomyView.setPin(PointF(1602f, 405f))



        return root
    }
}