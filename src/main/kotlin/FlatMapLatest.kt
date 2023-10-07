import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest

fun flatMapLatest() {
    emptyFlow<Unit>().flatMapLatest { emptyFlow<Unit>() }
}
