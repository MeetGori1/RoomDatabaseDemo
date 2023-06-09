package com.example.roomdatabasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.roomdatabasedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // this is not ideal way , kindly refer singleton pattern
//        database=Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()

        //by singleton pattern
        database = ContactDatabase.getDataBase(this)
        GlobalScope.launch {
            database.ContactDao().insertContact(Contact(0, "meet", "12345678980",Date()))
        }

        binding.text.setOnClickListener {
            database.ContactDao().getContact().observe(this) {
                binding.text.text = it[0].createdDate.toString()
            }
        }
    }
}