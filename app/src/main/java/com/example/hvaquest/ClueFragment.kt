package com.example.hvaquest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_clue.*

class ClueFragment : Fragment() {

    private lateinit var viewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_clue.setImageResource(viewModel.getClue())

        btn_next.setOnClickListener {
            if(viewModel.completedQuest()){
                findNavController().navigate(R.id.action_clueFragment_to_completedFragment)
            }
            else {
                viewModel.incrCurQuestion()
                findNavController().navigate(R.id.action_clueFragment_to_questionFragment)
            }
        }
    }
}
