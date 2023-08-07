package com.example.notessampleapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notessampleapp.ui.theme.BabyBlue
import com.example.notessampleapp.ui.theme.LightGreen
import com.example.notessampleapp.ui.theme.RedOrange
import com.example.notessampleapp.ui.theme.RedPink
import com.example.notessampleapp.ui.theme.Violet
import java.lang.Exception

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}


class InvalidNoteException(message: String): Exception(message)