package com.example.employeeviewer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.employeeviewer.Employee
import com.example.employeeviewer.EmployeeEntity

@Database(entities = [EmployeeEntity::class], version = 1, exportSchema = false)
abstract class EmployeeDataBase : RoomDatabase() {
    abstract fun employeesDAO(): EmployeesDAO
}