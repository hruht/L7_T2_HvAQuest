package com.example.hvaquest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestViewModel

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_number.text = getString(R.string.h_number, viewModel.curQuestion)

        var question = viewModel.getCurQuestion()
        tv_question_title.text = question.question
        rb_1.text = question.choices[0]
        rb_2.text = question.choices[1]
        rb_3.text = question.choices[2]

        btn_confirm.setOnClickListener {
            if (checkedRadioButtonByAnwser(radio_group.checkedRadioButtonId) == question.correctAnswer){
                findNavController().navigate(R.id.action_questionFragment_to_clueFragment)
            }
            else{
                Toast.makeText(view.context, "Incorrect answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkedRadioButtonByAnwser(id: Int): String{
        return when(id) {
            rb_1.id -> { rb_1.text.toString() }
            rb_2.id -> { rb_2.text.toString() }
            rb_3.id -> { rb_3.text.toString() }
            else -> ""
        }
    }
}
