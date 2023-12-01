package br.dev.geanbrandao.howtodo.cleannavigation.home

import androidx.lifecycle.ViewModel
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.AppNavigator
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Destination
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val appNavigator: AppNavigator,
): ViewModel() {

    fun onNavigateToUsersButtonClicked() {
        appNavigator.tryNavigateTo(Destination.UsersScreen())
    }

    fun onNavigateToMessagesButtonClicked() {
        appNavigator.tryNavigateTo(Destination.MessagesScreen())
    }

    fun onNavigateToDetailsButtonClicked() {
        appNavigator.tryNavigateTo(Destination.DetailsScreen())
    }
}