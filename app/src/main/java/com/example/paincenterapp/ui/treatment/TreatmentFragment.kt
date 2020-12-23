package com.example.paincenterapp.ui.treatment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.paincenterapp.R

class TreatmentFragment : Fragment() {

    private lateinit var treatmentViewModel: TreatmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        treatmentViewModel =
                ViewModelProvider(this).get(TreatmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_treatment, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        treatmentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}