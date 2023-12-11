package todoApp.viewHolder

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.javier.cursokotlin.R
import todoApp.sealed.Category

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    fun render(taskCategory: Category){
        tvCategoryName.text="EJEMPLO"

        when(taskCategory){
            Category.Business -> {
                tvCategoryName.text= "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
            Category.Other -> {
                tvCategoryName.text= "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )
            }
            Category.Personal -> {
                tvCategoryName.text= "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }
        }
    }
}