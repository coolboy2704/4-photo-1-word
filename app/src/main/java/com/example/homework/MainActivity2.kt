package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.homework.core.Constants
import com.example.homework.data.Question
import com.example.homework.databinding.ActivityMain2Binding
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private val questions = Constants.getQuestions()
    private lateinit var currentQuestion: Question
    private var index = -1
    private var answersBox = mutableListOf<androidx.appcompat.widget.LinearLayoutCompat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (questions.isNotEmpty()){
            currentQuestion = questions[++index]
        }


        val button = findViewById<ImageView>(R.id.iv_back)
        button.setOnClickListener {
            finish()
        }

        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_the_letters_two)
        val animationThree: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_the_letters_three)
        val animationFour: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_the_letters_four)
        val animationFive: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_the_letters_five)
        val animationSix: Animation = AnimationUtils.loadAnimation(this, R.anim.anim_the_letters_six)
        val buttonTwo = findViewById<MaterialButton>(R.id.bt_two)
        val buttonThree = findViewById<MaterialButton>(R.id.bt_three)
        val buttonFour = findViewById<MaterialButton>(R.id.bt_four)
        val buttonFive = findViewById<MaterialButton>(R.id.bt_five)
        val buttonSix = findViewById<MaterialButton>(R.id.bt_six)
        val buttonEight = findViewById<MaterialButton>(R.id.bt_eight)
        val buttonNine = findViewById<MaterialButton>(R.id.bt_nine)
        val buttonTen = findViewById<MaterialButton>(R.id.bt_ten)
        val buttonEleven = findViewById<MaterialButton>(R.id.bt_eleven)
        val buttonTwelve = findViewById<MaterialButton>(R.id.bt_twelve)

        buttonTwo.startAnimation(animation)
        buttonThree.startAnimation(animationThree)
        buttonFour.startAnimation(animationFour)
        buttonFive.startAnimation(animationFive)
        buttonSix.startAnimation(animationSix)
        buttonEight.startAnimation(animation)
        buttonNine.startAnimation(animationThree)
        buttonTen.startAnimation(animationFour)
        buttonEleven.startAnimation(animationFive)
        buttonTwelve.startAnimation(animationSix)

        setAnswerBox()

        setQuestion()

        printQuestion()

    }

    private fun setQuestion() {
        binding.apply {
            tvLiveNumber.text = currentQuestion.id.toString()

            ivOne.setImageResource(currentQuestion.images[0])
            ivTwo.setImageResource(currentQuestion.images[1])
            ivThree.setImageResource(currentQuestion.images[2])
            ivFour.setImageResource(currentQuestion.images[3])
        }

        setOptionLetters()
    }

    private fun setOptionLetters(){
        binding.apply {
            val optionLetters = mutableListOf<Char>()
            optionLetters.addAll(currentQuestion.answer.toList())

            repeat(12 - optionLetters.size){
                optionLetters.add(Random.nextInt(1040,1072).toChar())
            }
            optionLetters.shuffle()

            btOne.text = optionLetters[0].toString()
            btTwo.text = optionLetters[1].toString()
            btThree.text = optionLetters[2].toString()
            btFive.text = optionLetters[3].toString()
            btSix.text = optionLetters[4].toString()
            btSeven.text = optionLetters[5].toString()
            btEight.text = optionLetters[6].toString()
            btNine.text = optionLetters[7].toString()
            btFour.text = optionLetters[8].toString()
            btTen.text = optionLetters[9].toString()
            btEleven.text = optionLetters[10].toString()
            btTwelve.text = optionLetters[11].toString()
        }
    }

    private fun setAnswerBox() {
        binding.apply {
            answersBox.add(tvOne)
            answersBox.add(tvTwo)
            answersBox.add(tvThree)
            answersBox.add(tvFour)
            answersBox.add(tvFive)
            answersBox.add(tvSix)
            answersBox.add(tvSeven)
            answersBox.add(tvEight)
        }
    }

    private fun printQuestion() {
        setAnswerBox()
        repeat(currentQuestion.answer.length){
            answersBox[it].isVisible = true
        }
    }
}
