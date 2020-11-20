package com.example.employeeviewer.ui.specialty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeviewer.EmployeeEntity
import com.example.employeeviewer.R
import kotlinx.android.synthetic.main.one_of_rv.view.*
import java.util.*

class SpecialtyAdapter(private val callback: Callback) :
    RecyclerView.Adapter<SpecialtyAdapter.SpecialtyViewHolder>() {
    var specialties = mutableListOf<EmployeeEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : SpecialtyAdapter.SpecialtyViewHolder {
        return SpecialtyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.one_of_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SpecialtyAdapter.SpecialtyViewHolder, position: Int) {
        holder.bind(specialties.get(position))
    }

    override fun getItemCount(): Int {
        return specialties.size
    }

    fun updateSpecialty(specialty: List<EmployeeEntity>) {
        specialties.clear()
        specialties.addAll(specialty)
        notifyDataSetChanged()
    }

    interface Callback {
        fun specialtyOnClick(employeeEntity: EmployeeEntity)
    }


    inner class SpecialtyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.one_of_rv_id.setOnClickListener {
                callback.specialtyOnClick(specialties.get(adapterPosition))
            }
        }

        fun bind(employeeEntity: EmployeeEntity) {
            itemView.one_of_rv_id.text = employeeEntity.specialtyName.capitalize(Locale.ROOT)
        }
    }
}