package com.example.hvaquest

import androidx.lifecycle.ViewModel

class QuestViewModel : ViewModel() {

    var questRepository = QuestRepository()
    var curQuestion = 0

    fun getCurQuestion() : Question{
        return questRepository.getHvaQuest()[curQuestion]
    }

    fun getClue() : Int{
        return questRepository.getHvaQuest()[curQuestion].clue
    }

    fun incrCurQuestion(){
        curQuestion++
    }

    fun resetCurQuestion(){
        curQuestion = 0
    }

    fun completedQuest(): Boolean{
        return curQuestion == questRepository.getHvaQuest().count() - 1
    }
}