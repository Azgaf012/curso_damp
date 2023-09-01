package com.dapm.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.dapm.quizz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {

            showToast(R.string.toast_correcto)
        }

        binding.falseButton.setOnClickListener {
            showTopSnackbar(R.string.toast_incorrecto,R.color.red)
        }
    }

    private fun showTopSnackbar(messageResId: Int, backgroundColorResId: Int) {
        val snackbar = Snackbar.make(binding.root, messageResId, Snackbar.LENGTH_LONG)

        val params = snackbar.view.layoutParams as CoordinatorLayout.LayoutParams
        params.gravity = Gravity.TOP
        snackbar.view.layoutParams = params

        snackbar.setBackgroundTint(ContextCompat.getColor(this, backgroundColorResId))
        snackbar.show()
    }

    private fun showToast(messageResId: Int) {
        val message = getString(messageResId)

        val layoutInflater = layoutInflater
        val customToastRoot = layoutInflater.inflate(R.layout.custom_toast, null)
        val customToastText: TextView = customToastRoot.findViewById(R.id.toast_text)
        customToastText.text = message

        val customToast = Toast(applicationContext)
        customToast.view = customToastRoot
        customToast.duration = Toast.LENGTH_SHORT
        customToast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
        customToast.show()
    }

}