package com.example.logindesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logindesign.ui.theme.LoginDesignTheme
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            LoginDesignTheme(darkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator(isDarkMode) { isDarkMode = it }
                }
            }
        }
    }
}

@Composable
fun Calculator(isDarkMode: Boolean, onThemeChange: (Boolean) -> Unit) {
    var input by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Theme toggle button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { onThemeChange(!isDarkMode) }) {
                Icon(
                    painter = painterResource(
                        if (isDarkMode) R.drawable.ic_sun else R.drawable.ic_moon
                    ),
                    contentDescription = "Toggle Theme",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        BasicTextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
                .padding(16.dp),
            textStyle = TextStyle(fontSize = 24.sp, color = Color.Black),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { result = evaluateExpression(input.text) })
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = result,
            style = TextStyle(fontSize = 30.sp, color = MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Grid layout for calculator buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton(text = "(") { input = TextFieldValue(input.text + "(") }
                CalculatorButton(text = ")") { input = TextFieldValue(input.text + ")") }
                CalculatorButton(text = "C") { input = TextFieldValue("") }
                CalculatorButton(text = "←") { input = TextFieldValue(input.text.dropLast(1)) }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton(text = "7") { input = TextFieldValue(input.text + "7") }
                CalculatorButton(text = "8") { input = TextFieldValue(input.text + "8") }
                CalculatorButton(text = "9") { input = TextFieldValue(input.text + "9") }
                CalculatorButton(text = "/") { input = TextFieldValue(input.text + "/") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton(text = "4") { input = TextFieldValue(input.text + "4") }
                CalculatorButton(text = "5") { input = TextFieldValue(input.text + "5") }
                CalculatorButton(text = "6") { input = TextFieldValue(input.text + "6") }
                CalculatorButton(text = "*") { input = TextFieldValue(input.text + "*") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton(text = "1") { input = TextFieldValue(input.text + "1") }
                CalculatorButton(text = "2") { input = TextFieldValue(input.text + "2") }
                CalculatorButton(text = "3") { input = TextFieldValue(input.text + "3") }
                CalculatorButton(text = "-") { input = TextFieldValue(input.text + "-") }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton(text = "0") { input = TextFieldValue(input.text + "0") }
                CalculatorButton(text = ".") { input = TextFieldValue(input.text + ".") }
                CalculatorButton(text = "+") { input = TextFieldValue(input.text + "+") }
                CalculatorButton(text = "=") { result = evaluateExpression(input.text) }
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp)
            .size(64.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        shape = MaterialTheme.shapes.small
    ) {
        Text(text = text, style = TextStyle(fontSize = 24.sp, color = Color.White))
    }
}

fun evaluateExpression(expression: String): String {
    return try {
        val result = ExpressionBuilder(expression).build().evaluate()
        result.toString()
    } catch (e: Exception) {
        "Error"
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    var isDarkMode by remember { mutableStateOf(false) }
    LoginDesignTheme(darkTheme = isDarkMode) {
        Calculator(isDarkMode) { isDarkMode = it }
    }
}
