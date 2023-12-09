package com.raka.muplayerapps.data

import com.raka.muplayerapps.model.Player
import com.raka.muplayerapps.model.PlayerData

class PlayerRepository {
    fun getPlayer() : List<Player> {
        return PlayerData.player
    }

    fun searchPlayer(query: String) : List<Player> {
        return PlayerData.player.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}