package br.dev.geanbrandao.howtodo.cleannavigation.userdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.GoTo
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun UsersDetailsScreen(
    viewModel: UsersDetailsViewModel = koinViewModel(),
) {

    val viewState = viewModel.viewState.collectAsState().value

    Column {
        Screen(text = "Users Details screen")
        GoTo(text = "Back") {
            viewModel.onBackButtonClicked()
        }
        Screen(text = "One ${viewState.firstName}, two ${viewState.lastName}")
    }
}