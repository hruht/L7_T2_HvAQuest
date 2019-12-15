package com.example.hvaquest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_completed.*

class CompletedFragment : Fragment() {
    private lateinit var viewModel: QuestViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_finish.setOnClickListener {
            viewModel.resetCurQuestion()
            findNavController().navigate(R.id.action_completedFragment_to_homeFragment)
        }
    }
}
