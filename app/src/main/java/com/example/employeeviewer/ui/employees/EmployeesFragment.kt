package com.example.employeeviewer.ui.employees

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.R
import kotlinx.android.synthetic.main.fragment_employees.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class EmployeesFragment : MvpAppCompatFragment(R.layout.fragment_employees), EmployeesView {
    companion object {
        fun newInstance(specialtyId: Long): EmployeesFragment {
            val args = Bundle()
            args.putLong("specialty_key", specialtyId)

            val fragment = EmployeesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val employeesPresenter by moxyPresenter { EmployeesPresenter() }
    private val adapter = EmployeesAdapter(object :EmployeesAdapter.Callback {
        override fun employeesOnClick(employeeEntity: EmployeeEntity) {
            employeesPresenter.onEmployeesOnClick(employeeEntity)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val specialtyId = arguments?.getLong("specialty_key")!!
        employeesPresenter.init(specialtyId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        employees_recycler_view.layoutManager = LinearLayoutManager(context)
        employees_recycler_view.adapter = adapter
    }

    override fun updateEmployees(employees: List<EmployeeEntity>) {
        adapter.updateEmployees(employees)
    }
}