package com.broncospace.android.starvis.spacecraft

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

@Dao
interface SpacecraftDao {
    @Query("SELECT * FROM SpacecraftItem")
    suspend fun getSpacecraft(): List<SpacecraftItem>
    @Query("SELECT * FROM SpacecraftItem WHERE id=(:id)")
    suspend fun getSpacecraft(id: UUID): SpacecraftItem
}