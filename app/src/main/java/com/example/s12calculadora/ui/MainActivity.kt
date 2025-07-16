package com.example.s12calculadora.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.s12calculadora.databinding.ActivityMainBinding
import com.example.s12calculadora.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observers
        viewModel.mainDisplay.observe(this, Observer {
            binding.tvMainDisplay.text = it
        })

        viewModel.secondaryDisplay.observe(this, Observer {
            binding.tvSecondaryDisplay.text = it
        })

        // Number buttons
        listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        ).forEach { button ->
            button.setOnClickListener {
                viewModel.onNumberClick(button.text.toString())
            }
        }

        // Operator buttons
        binding.btnAdd.setOnClickListener { viewModel.onOperatorClick("+") }
        binding.btnSubtract.setOnClickListener { viewModel.onOperatorClick("−") }
        binding.btnMultiply.setOnClickListener { viewModel.onOperatorClick("×") }
        binding.btnDivide.setOnClickListener { viewModel.onOperatorClick("÷") }

        // Other functions
        binding.btnEquals.setOnClickListener { viewModel.onEqualsClick() }
        binding.btnClear.setOnClickListener { viewModel.onClearClick() }
        binding.btnDelete.setOnClickListener { viewModel.onDeleteClick() }
        binding.btnDecimal.setOnClickListener { viewModel.onDecimalClick() }
        binding.btnPercent.setOnClickListener { viewModel.onPercentClick() }
    }
}
