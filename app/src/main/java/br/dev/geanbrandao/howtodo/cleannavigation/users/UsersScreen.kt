package br.dev.geanbrandao.howtodo.cleannavigation.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.GoTo
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = koinViewModel(),
) {
    Column {
        Screen(text = "Users screen")
        GoTo(text = "Back") {
            viewModel.onBackButtonClicked()
        }
        LazyColumn {
            val list = (1..50).toList()
            items(list) {
                Text(
                    text = "User Name $it",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onUserRowClicked("first $it", "last $it")
                        },
                )
            }
        }
    }
}