package com.example.employeeviewer.ui.specialty

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.R
import kotlinx.android.synthetic.main.fragment_specialty.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SpecialtyFragment : MvpAppCompatFragment(R.layout.fragment_specialty), SpecialtyView {

    private val specialtyPresenter by moxyPresenter { SpecialtyPresenter() }

    var specialtyAdapter: SpecialtyAdapter =
        SpecialtyAdapter(callback = object : SpecialtyAdapter.Callback {
            override fun specialtyOnClick(employeeEntity: EmployeeEntity) {
                specialtyPresenter.onSpecialtyOnClick(employeeEntity)
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycleView()
    }

    override fun updateSpecialities(specialties: List<EmployeeEntity>) {

        specialtyAdapter.updateSpecialty(specialties)
    }

    private fun initRecycleView() {
        rv_id.layoutManager = LinearLayoutManager(context)
        rv_id.adapter = specialtyAdapter
    }
}