package com.example.employeeviewer.ui.employees

import com.example.employeeviewer.EmployeeEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

@Skip
interface EmployeesView : MvpView {
    fun updateEmployees(employees: List<EmployeeEntity>)
}
