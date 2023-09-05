
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

const val MAXIMIZED_INITIAL = false
fun main() {
    application {
        var maximized by remember { mutableStateOf(MAXIMIZED_INITIAL) }

        val windowState = if (maximized) {
            WindowState(
                placement = WindowPlacement.Maximized,
                size = DpSize.Unspecified,
                position = WindowPosition.Aligned(Alignment.Center),
            )
        } else {
            WindowState(
                placement = WindowPlacement.Floating,
                size = DpSize(300.dp, 800.dp),
                position = WindowPosition.Aligned(Alignment.Center),
            )
        }

        Window(onCloseRequest = ::exitApplication, state = windowState) {
            Box(
                Modifier
                    .fillMaxSize()
                    .layout { measurable, constraints ->
                        println("layout $constraints")
                        val placeable = measurable.measure(constraints)
                        layout(placeable.width, placeable.height) { placeable.place(0, 0) }
                    }
                    .clickable { maximized = !maximized }
            )
        }
    }
}
