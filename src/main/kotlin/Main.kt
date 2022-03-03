import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    var parentKeyEvent by remember { mutableStateOf("") }
    var parentFocusEvent by remember { mutableStateOf("") }

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .focusable()
                .onFocusEvent {
                    parentFocusEvent = it.toString()
                }
                .onKeyEvent {
                    parentKeyEvent = "${it.key} ${it.type}"
                    false
                }
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                var textFieldValue1 by remember { mutableStateOf("") }
                TextField(
                    value = textFieldValue1,
                    onValueChange = { textFieldValue1 = it },
                    singleLine = true,
                )

                var textFieldValue2 by remember { mutableStateOf("") }
                TextField(
                    value = textFieldValue2,
                    onValueChange = { textFieldValue2 = it },
                    singleLine = true,
                )

                Button(onClick = { /* no-op */ }) {
                    Text("Dummy button (for focus)")
                }

                Text("Last parent key event: $parentKeyEvent")

                Text("Last parent focus event: $parentFocusEvent")
            }
        }
    }
}

fun main() {
    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}
