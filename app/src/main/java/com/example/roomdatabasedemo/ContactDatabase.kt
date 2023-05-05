package com.example.roomdatabasedemo

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
@Database(entities = [Contact::class],version=1)
abstract class ContactDatabase :RoomDatabase(){

    abstract fun ContactDao():ContactDAO
}