package com.blueray.rowsandcolumns.number_guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {

    private var number = Random.nextInt(0, 101)
    private var attempts = 0
    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.OnGuessClick -> {
                val guess = state.value.numberText.toIntOrNull()

                attempts++
                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> {
                                "Please Enter a Number"
                            }

                            guess < number -> {
                                "Nope, my number is larger "
                            }

                            guess > number -> {
                                "Nope, my number is smaller"
                            }

                            else -> {
                                "That was it ! you needed $attempts attempts"
                            }
                        }, isGuessCorrect = guess == number, numberText = ""
                    )
                }

            }

            is NumberGuessAction.OnNumberTextChange -> {
                _state.value = state.value.copy()
                _state.update {
                    it.copy(
                        numberText = action.numberText
                    )
                }

            }

            NumberGuessAction.OnStartNewGameButtonClick -> {
                _state.update {
                    it.copy(
                        numberText = "",
                        guessText = null,
                        isGuessCorrect = false

                    )
                }

                number = Random.nextInt(0, 101)
                attempts = 0
            }

        }
    }
}