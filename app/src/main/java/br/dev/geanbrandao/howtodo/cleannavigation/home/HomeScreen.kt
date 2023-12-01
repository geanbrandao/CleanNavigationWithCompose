package br.dev.geanbrandao.howtodo.cleannavigation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.GoTo
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    Column {
        Screen(text = "Home Screen")
        GoTo(text = "Users") {
            viewModel.onNavigateToUsersButtonClicked()
        }
        GoTo(text = "Messages") {
            viewModel.onNavigateToMessagesButtonClicked()
        }
        GoTo(text = "Details") {
            viewModel.onNavigateToDetailsButtonClicked()
        }
    }
}