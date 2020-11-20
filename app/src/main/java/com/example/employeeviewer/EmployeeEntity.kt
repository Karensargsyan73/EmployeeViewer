package com.example.employeeviewer

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "employeesTable")
class EmployeeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var lastName: String = "",
    var birthday: String? = null,
    var avatarUrl: String? = null,
    var specialtyId: Long = 0,
    var specialtyName: String = ""
) : Serializable