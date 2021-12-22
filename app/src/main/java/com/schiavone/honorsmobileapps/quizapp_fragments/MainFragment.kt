package com.schiavone.honorsmobileapps.quizapp_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.schiavone.honorsmobileapps.quizapp_fragments.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    data class Question(val resourceId: Int, val answer: Boolean) {
    }

    var questionIndex = 0
    val questionList = listOf(
        Question(R.string.question1, true),
        Question(R.string.question2, true), Question(R.string.question3, false),
        Question(R.string.question4, true), Question(R.string.question5, false)
    )
    private var _binding : FragmentMainBinding?=null
    private val binding get() = _binding !!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentMainBinding.inflate(inflater,container,false)
        val rootview=binding.root

        if (savedInstanceState != null)
            questionIndex = savedInstanceState.getInt("question_number")
        updateQuestionText()
        binding.button.setOnClickListener { view ->
            checkAnswer(true)
        }
        binding.button2.setOnClickListener { view ->
            checkAnswer(false)
        }
        binding.button3.setOnClickListener { view ->
            nextQuestion()
        }
        binding.questionText.setOnClickListener { view ->
            nextQuestion()
        }
        return rootview
    }
    override fun onDestroy(){
        super.onDestroy()
        _binding=null
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("question_number", questionIndex)
    }

    fun nextQuestion() {
        questionIndex += 1
        questionIndex %= questionList.size
        updateQuestionText()
    }

    fun updateQuestionText() {
        binding.questionText.text = getString(questionList.get(questionIndex).resourceId)
    }

    fun checkAnswer(answer: Boolean) {
        if (questionList.get(questionIndex).answer == answer) {
            Toast.makeText(activity, R.string.toast1, Toast.LENGTH_SHORT).show()
        } else Toast.makeText(activity, R.string.toast2, Toast.LENGTH_SHORT).show()


    }

}