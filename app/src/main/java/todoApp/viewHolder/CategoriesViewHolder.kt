package todoApp.viewHolder

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.javier.cursokotlin.R
import androidx.cardview.widget.CardView
import todoApp.sealed.Category

class CategoriesViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)
    fun render(taskCategory: Category, onItemSelected: (Int) -> Unit){
        val color = if(taskCategory.isSelected){
            R.color.todo_background_card
        }else{
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        itemView.setOnClickListener{
            onItemSelected(layoutPosition)
        }

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