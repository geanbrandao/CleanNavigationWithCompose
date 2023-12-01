package br.dev.geanbrandao.howtodo.cleannavigation.users

import androidx.lifecycle.ViewModel
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.AppNavigator
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UsersViewModel(
    private val appNavigator: AppNavigator,
): ViewModel() {
//    private val _viewState = MutableStateFlow(UsersViewState())
//    val viewState = _viewState.asStateFlow()

    fun onBackButtonClicked() {
        appNavigator.tryNavigateBack()
    }

    fun onUserRowClicked(firstName: String, lastName: String) {
        appNavigator.tryNavigateTo(
            Destination.UserDetailsScreen(
                fistName = firstName,
                lastName = lastName
            )
        )
    }
}