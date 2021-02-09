package android.com.example.colormyviews

import android.com.example.colormyviews.databinding.ActivityMainBinding
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val box_one_text = binding.boxOneText
        val box_two_text = binding.boxTwoText
        val box_three_text = binding.boxThreeText
        val box_four_text = binding.boxFourText
        val box_five_text = binding.boxFiveText
        val constraint_layout=binding.constraintLayout
        val clickableViews: List<View> =
                listOf(box_one_text, box_two_text , box_three_text,box_four_text, box_five_text, constraint_layout)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }


    private fun makeColored(view: View) {
        when (view.id) {
            //Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_two_text -> view.setBackgroundColor(Color.MAGENTA)

            //Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_orange_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            else -> view.setBackgroundColor(Color.YELLOW)
        }
    }
}