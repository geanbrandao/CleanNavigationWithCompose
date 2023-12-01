package br.dev.geanbrandao.howtodo.cleannavigation.navigation

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.dev.geanbrandao.howtodo.cleannavigation.home.HomeScreen
import br.dev.geanbrandao.howtodo.cleannavigation.userdetails.UsersDetailsScreen
import br.dev.geanbrandao.howtodo.cleannavigation.users.UsersScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationScreen(
    viewModel: NavigationViewModel = koinViewModel()
) {

    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = viewModel.navigationChannel,
        navHostController = navController
    )

    NavigationGraph(
        navController = navController,
        startDestination = Destination.HomeScreen,
        builder = {
            composable(destination = Destination.HomeScreen) {
                HomeScreen()
            }
            composable(destination = Destination.UsersScreen) {
                UsersScreen()
            }
            composable(destination = Destination.UserDetailsScreen) {
                UsersDetailsScreen()
            }
            composable(destination = Destination.MessagesScreen) {
                Screen(text = "Message Scree")
            }
            composable(destination = Destination.DetailsScreen) {
                Screen(text = "Message Screen")
            }
        }
    )
}

@Composable
private fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.GoTo(text: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
        Text(text = text)
    }
}

@Composable
fun Screen(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}