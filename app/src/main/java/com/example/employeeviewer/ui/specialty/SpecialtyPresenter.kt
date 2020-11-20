package com.example.employeeviewer.ui.specialty

import com.example.employeeviewer.*
import com.example.employeeviewer.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback

class SpecialtyPresenter : MvpPresenter<SpecialtyView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        NetworkManager.getApi()
            .getEmployees()
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    val employeeModel: List<Employee> = response.body()?.response!!
                    val employeeListEntity = mutableListOf<EmployeeEntity>()

                    employeeModel.forEach { emploee ->

                        emploee.specialty.forEach { specialty ->
                            var entity: EmployeeEntity = EmployeeEntity(
                                emploee.id,
                                emploee.name,
                                emploee.lastName,
                                emploee.birthday,
                                emploee.avatarUrl,
                                specialty.specialtyId,
                                specialty.name
                            )

                            employeeListEntity.add(entity)
                        }
                    }
                    App.INSTANCE.database.employeesDAO().deleteAll()
                    App.INSTANCE.database.employeesDAO().addEmployees(employeeListEntity)

                    val specialtyCollection = App.INSTANCE.database.employeesDAO()
                        .readSpecialtyData()
                        .distinctBy { it.specialtyName }

                    viewState.updateSpecialities(specialtyCollection)
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                    t.printStackTrace()
                    println()
                }
            })
    }

    fun onSpecialtyOnClick(employeeEntity: EmployeeEntity) {
        App.INSTANCE.router.navigateTo(Screens.employees(employeeEntity.specialtyId))
    }
}