package com.example.employeeviewer

import android.app.Application
import androidx.room.Room
import com.example.employeeviewer.data.EmployeeDataBase
import com.github.terrakok.cicerone.Cicerone

class App : Application() {
    companion object {
        lateinit var INSTANCE: App
            private set
    }

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    lateinit var database: EmployeeDataBase

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        database = Room
            .databaseBuilder(applicationContext, EmployeeDataBase::class.java, "employeesDataBase")
            .allowMainThreadQueries()
            .build()
    }

}