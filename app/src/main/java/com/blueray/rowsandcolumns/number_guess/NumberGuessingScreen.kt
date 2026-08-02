package com.blueray.rowsandcolumns.number_guess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme


@Composable
fun NumberGuessingScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    NumberGuessingScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun NumberGuessingScreen(
    modifier: Modifier = Modifier,
    state: NumberGuessState,
    onAction: (NumberGuessAction) -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)
    ) {
        TextField(
            value = state.numberText,
            onValueChange = { newText ->
                onAction(NumberGuessAction.OnNumberTextChange(newText))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Button(onClick = {
            onAction(
                NumberGuessAction.OnGuessClick
            )
        }) {
            Text("MAKE A GUESS")
        }

        if (state.guessText != null) {
            Text(state.guessText)
        }

        if (state.isGuessCorrect) {
            Button(onClick = { onAction(NumberGuessAction.OnStartNewGameButtonClick) }) {
                Text("Start New Game")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun NumberGuessingScreenPrev() {
    RowsAndColumnsTheme {
        NumberGuessingScreen(
            state = NumberGuessState(),
            modifier = Modifier.fillMaxSize(),
            onAction = {}
        )
    }
}