package com.example.employeeviewer

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("response")
    val response: List<Employee>
)

class Employee(
    var id: Long = 0,
    @SerializedName("f_name")
    var name: String = "",
    @SerializedName("l_name")
    var lastName: String = "",
    @SerializedName("birthday")
    var birthday: String? = null,
    @SerializedName("avatr_url")
    var avatarUrl: String? = null,

    @SerializedName("specialty")
    var specialty: List<Specialty> = emptyList()
)

class Specialty(
    @SerializedName("specialty_id")
    val specialtyId: Long,
    @SerializedName("name")
    val name: String
)