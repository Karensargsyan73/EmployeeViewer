package com.example.employeeviewer.ui.detailemployee

import com.example.employeeviewer.EmployeeEntity
import moxy.MvpPresenter

class DetailEmployeePresenter : MvpPresenter<DetailEmployeeVIew>() {
    private lateinit var employee: EmployeeEntity

    fun init(employee: EmployeeEntity) {
        this.employee = employee
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEmployees(employee)
    }
}