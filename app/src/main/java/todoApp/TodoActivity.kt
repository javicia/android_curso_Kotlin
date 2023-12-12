package todoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.javier.cursokotlin.R
import todoApp.adapter.CategoriesAdapter
import todoApp.adapter.TasksAdapter
import todoApp.sealed.Category
import todoApp.sealed.Category.*
import todoApp.sealed.Tasks
import java.text.FieldPosition

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Tasks("PruebaBussines", Business),
        Tasks("PruebaPersonal", Personal),
        Tasks("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabTask: FloatingActionButton

    private lateinit var rvTasks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabTask= findViewById(R.id.fabTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories){position -> updateCategories(position)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) {position -> onItemSelected(position)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter=tasksAdapter
    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun initListeners() {
       fabTask.setOnClickListener {
           showDialog()
       }
    }

    private fun updateCategories(position: Int){
    categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks(){
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val newTasks= tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
    tasksAdapter.notifyDataSetChanged()
    }

    private fun showDialog() {
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: Category = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_bussiness) -> Business
                    getString(R.string.todo_dialog_personal) -> Personal
                    else -> {
                        Other
                    }
                }

                tasks.add(Tasks(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }
    }

}