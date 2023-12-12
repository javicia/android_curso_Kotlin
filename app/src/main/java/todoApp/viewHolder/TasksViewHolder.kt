package todoApp.viewHolder

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.javier.cursokotlin.R
import todoApp.sealed.Category
import todoApp.sealed.Tasks

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Tasks) {
        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }


        tvTask.text = task.name
        cbTask.isChecked = task.isSelected

        val color = when(task.category){
            Category.Business -> R.color.todo_business_category
            Category.Other -> R.color.todo_other_category
            Category.Personal -> R.color.todo_personal_category
        }

        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, color)
        )
    }
    }
