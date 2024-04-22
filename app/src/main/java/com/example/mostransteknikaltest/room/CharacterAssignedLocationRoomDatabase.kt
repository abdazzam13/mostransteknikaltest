package com.example.mostransteknikaltest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation

@Database(entities = [CharacterWithAssignedLocation::class], version = 1)
abstract class CharacterAssignedLocationRoomDatabase: RoomDatabase() {
    abstract fun characterAssignedLocationDao(): CharacterAssignedLocationDao

    companion object {
        @Volatile
        private var INSTANCE: CharacterAssignedLocationRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): CharacterAssignedLocationRoomDatabase {
            if (INSTANCE == null) {
                synchronized(CharacterAssignedLocationRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CharacterAssignedLocationRoomDatabase::class.java, "characterAssignedLocation_database")
                        .build()
                }
            }
            return INSTANCE as CharacterAssignedLocationRoomDatabase
        }
    }
}