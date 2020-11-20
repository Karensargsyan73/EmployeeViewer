package com.example.employeeviewer.ui.detailemployee

import com.example.employeeviewer.EmployeeEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

@Skip
interface DetailEmployeeVIew : MvpView {
    fun setEmployees(employees: EmployeeEntity)
}
