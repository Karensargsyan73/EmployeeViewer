package com.example.employeeviewer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.employeeviewer.EmployeeEntity

@Dao
interface EmployeesDAO {
    @Insert
    fun addEmployees(response: EmployeeEntity)

    @Insert
    fun addEmployees(response: List<EmployeeEntity>)

    @Query("SELECT * FROM employeesTable ORDER BY id ASC ")
    fun readSpecialtyData(): List<EmployeeEntity>

    @Query("SELECT * FROM employeesTable WHERE specialtyId = :specialtyId ")
    fun readBySpecialtyIdData(specialtyId: Long): List<EmployeeEntity>

    @Query("DELETE FROM employeesTable")
    fun deleteAll()
}