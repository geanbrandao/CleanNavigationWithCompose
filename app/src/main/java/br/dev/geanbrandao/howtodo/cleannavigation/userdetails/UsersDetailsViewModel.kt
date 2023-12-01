package br.dev.geanbrandao.howtodo.cleannavigation.userdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.AppNavigator
import br.dev.geanbrandao.howtodo.cleannavigation.navigation.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UsersDetailsViewModel(
    private val appNavigator: AppNavigator,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {
    private val _viewState = MutableStateFlow(UserDetailsViewState())
    val viewState = _viewState.asStateFlow()

    init {
        val firstName =
            savedStateHandle.get<String>(Destination.UserDetailsScreen.FIST_NAME_KEY) ?: ""
        val lastName =
            savedStateHandle.get<String>(Destination.UserDetailsScreen.LAST_NAME_KEY) ?: ""

        _viewState.update {
            it.copy(
                firstName = firstName,
                lastName = lastName
            )
        }
    }

    fun onBackButtonClicked() {
        appNavigator.tryNavigateBack()
    }
}

data class UserDetailsViewState(
    val firstName: String = "",
    val lastName: String = ""
)