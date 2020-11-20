package com.example.employeeviewer.ui.detailemployee

import android.os.Bundle
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_employee.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*

class DetailEmployeeFragment : MvpAppCompatFragment(R.layout.fragment_detail_employee), DetailEmployeeVIew {
    companion object {
        fun newInstance(employee: EmployeeEntity): DetailEmployeeFragment {
            val args = Bundle()
            args.putSerializable("employee_key", employee)

            val fragment = DetailEmployeeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val presenter by moxyPresenter { DetailEmployeePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val employee = arguments?.getSerializable("employee_key") as EmployeeEntity
        presenter.init(employee)
    }

    override fun setEmployees(employees: EmployeeEntity) {
        val name = employees.name.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
        val lastName = employees.lastName.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
        val birthday = if (employees.birthday.isNullOrBlank()) {
            "-"
        } else {
            employees.birthday
        }

        name_id.text = name
        last_name_id.text = lastName
        birthday_id.text = birthday

        if (employees.avatarUrl?.isNotBlank() == true) {
            Picasso.get()
                .load(employees.avatarUrl)
                .into(photo_id)
        }
    }
}