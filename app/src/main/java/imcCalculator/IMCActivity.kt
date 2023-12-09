package imcCalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import com.javier.cursokotlin.R
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()
        InitUI()
    }


    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight= findViewById(R.id.tvHeight)
        rsHeight= findViewById(R.id.rsHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            setGenderColor()
            changeGender()}
        viewFemale.setOnClickListener {
            setGenderColor()
            changeGender()}

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            var result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }

    private fun changeGender(){
    isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor() {
        getCardBackground(isMaleSelected)
        getCardBackground(isFemaleSelected)
        viewMale.setCardBackgroundColor(getCardBackground(isMaleSelected))
        viewMale.setCardBackgroundColor(getCardBackground(isFemaleSelected))
    }

    private fun getCardBackground(isSelectedComponent: Boolean): Int{


        var colorReferences = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReferences)
    }


    private fun InitUI() {
    setGenderColor()
    }


}