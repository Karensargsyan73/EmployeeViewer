package com.example.employeeviewer.ui.employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.R
import kotlinx.android.synthetic.main.one_of_rv.view.*
import java.util.*

class EmployeesAdapter(
    private val callback: Callback
) : RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>() {
    var employees = mutableListOf<EmployeeEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        return EmployeesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.one_of_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        holder.bind(employees.get(position))
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    fun updateEmployees(employeesList: List<EmployeeEntity>) {
        employees.clear()
        employees.addAll(employeesList)
        notifyDataSetChanged()
    }

    interface Callback {
        fun employeesOnClick(employeeEntity: EmployeeEntity)
    }

    inner class EmployeesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.one_of_rv_id.setOnClickListener {
                callback.employeesOnClick(employees.get(adapterPosition))
            }
        }

        fun bind(employeeEntity: EmployeeEntity) {
            val name = employeeEntity.name.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
            val lastName = employeeEntity.lastName.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)

            val birthday = if (employeeEntity.birthday.isNullOrBlank()) {
                "-"
            } else {
                employeeEntity.birthday
            }

            itemView.one_of_rv_id.text = "$name $lastName $birthday"
        }
    }
}