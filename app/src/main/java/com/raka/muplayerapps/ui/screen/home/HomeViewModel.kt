package com.raka.muplayerapps.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raka.muplayerapps.data.PlayerRepository
import com.raka.muplayerapps.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: PlayerRepository) : ViewModel() {
    private val _getPlayers = MutableStateFlow(
        repository.getPlayer()
            .groupBy { it.name[0] }
    )
    val getPlayers: StateFlow<Map<Char, List<Player>>> get() = _getPlayers

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _getPlayers.value = repository.searchPlayer(_query.value)
            .groupBy { it.name[0] }
    }
}