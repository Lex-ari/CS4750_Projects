package com.broncospace.android.starvis.spacecraft

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class SpacecraftItem(
    @PrimaryKey val id: UUID,
    val noradId: Integer,
    val photoLink: String,
)