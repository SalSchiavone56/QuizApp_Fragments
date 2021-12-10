package com.schiavone.honorsmobileapps.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.schiavone.honorsmobileapps.quizapp.databinding.ActivityMainBinding

const val QUESTION_NUMBER = "num_of_question_key"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    data class Question(val resourceId: Int, val answer: Boolean) {
    }

    var questionIndex = 0
    val questionList = listOf(
        Question(R.string.question1, true),
        Question(R.string.question2, true), Question(R.string.question3, false),
        Question(R.string.question4, true), Question(R.string.question5, false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null)
            questionIndex = savedInstanceState.getInt(QUESTION_NUMBER)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(QUESTION_NUMBER, questionIndex)
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
            Toast.makeText(this, R.string.toast1, Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, R.string.toast2, Toast.LENGTH_SHORT).show()


    }
}