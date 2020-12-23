package com.example.paincenterapp.ui.doctors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.paincenterapp.R

class DoctorsFragment : Fragment() {

    private lateinit var doctorsViewModel: DoctorsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        doctorsViewModel =
                ViewModelProvider(this).get(DoctorsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_treatment, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        doctorsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}