package com.example.employeeviewer.ui.employees

import com.example.employeeviewer.App
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.navigation.Screens
import moxy.MvpPresenter

class EmployeesPresenter : MvpPresenter<EmployeesView>() {
    private var specialtyId: Long = 0

    fun init(specialtyId: Long) {
        this.specialtyId = specialtyId
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val employees = App.INSTANCE.database.employeesDAO()
            .readBySpecialtyIdData(specialtyId)
        viewState.updateEmployees(employees)
    }

    fun onEmployeesOnClick(employeeEntity: EmployeeEntity) {
        App.INSTANCE.router.navigateTo(Screens.detailEmployee(employeeEntity))
    }
}