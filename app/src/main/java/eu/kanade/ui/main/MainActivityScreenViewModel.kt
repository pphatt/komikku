package eu.kanade.ui.main;

import androidx.compose.runtime.Immutable
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityScreenViewModel @Inject constructor(
    // would have something like repo for accesstoken
    // or logout handler to passing the constructor
) : ViewModel() {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()
    private var state: State
        get() = _uiState.value
        set(value) {
            _uiState.update { value }
        }

    init {
        viewModelScope.launch {
            state = state.copy(
                isInitialized = true
            )
        }
    }

    @Immutable
    data class State(
        val isInitialized: Boolean = false,
//        val userLoggedIn: Boolean = false,
//        val defaultHomeScreen: String = Screen.Library.route,
//        val kickUserToLogin: Unit? = null
    ) {
        // declare some complex value here
    }
}
