package com.example.employeeviewer.ui.specialty

import com.example.employeeviewer.EmployeeEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

@Skip
interface SpecialtyView : MvpView {
    fun updateSpecialities(employees: List<EmployeeEntity>)
}
