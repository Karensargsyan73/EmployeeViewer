package com.example.employeeviewer.navigation

import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.ui.detailemployee.DetailEmployeeFragment
import com.example.employeeviewer.ui.employees.EmployeesFragment
import com.example.employeeviewer.ui.specialty.SpecialtyFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun specialty() = FragmentScreen("specialty") { SpecialtyFragment() }
    fun employees(specialtyId: Long) = FragmentScreen("employees") { EmployeesFragment.newInstance(specialtyId) }
    fun detailEmployee(specialty: EmployeeEntity) = FragmentScreen("detailEmployee") { DetailEmployeeFragment.newInstance(specialty) }
}