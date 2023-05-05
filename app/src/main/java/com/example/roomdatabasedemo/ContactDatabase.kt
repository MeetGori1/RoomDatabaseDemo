package com.example.roomdatabasedemo

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Contact::class],version=1)
abstract class ContactDatabase :RoomDatabase(){

    abstract fun ContactDao():ContactDAO

    companion object{
        @Volatile
        private var INSTANCE:ContactDatabase?=null
        fun getDataBase(context:Context):ContactDatabase{
            //it is singleton pattern to prevent create multiple instance of same database
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactDB").build()
                }
            }

            return INSTANCE!!
        }
    }
}