package com.example.s12calculadora.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s12calculadora.model.CalculatorModel

class CalculatorViewModel : ViewModel() {

    private val calculator = CalculatorModel()

    private val _mainDisplay = MutableLiveData("0")
    val mainDisplay: LiveData<String> get() = _mainDisplay

    private val _secondaryDisplay = MutableLiveData("")
    val secondaryDisplay: LiveData<String> get() = _secondaryDisplay

    private var currentInput = ""
    private var currentOperator = ""
    private var operand = ""

    fun onNumberClick(number: String) {
        if (currentInput == "0") currentInput = ""
        currentInput += number
        _mainDisplay.value = currentInput
    }

    fun onDecimalClick() {
        if (!currentInput.contains(".")) {
            currentInput = if (currentInput.isEmpty()) "0." else "$currentInput."
            _mainDisplay.value = currentInput
        }
    }

    fun onOperatorClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            operand = currentInput
            currentInput = ""
            currentOperator = operator
            _secondaryDisplay.value = "$operand $operator"
            _mainDisplay.value = "0"
        }
    }

    fun onEqualsClick() {
        if (operand.isNotEmpty() && currentInput.isNotEmpty()) {
            val result = calculator.calculate(operand, currentInput, currentOperator)

            // Formatear el resultado para eliminar ".0" si es un número entero
            val formattedResult = if (result.contains(".0")) {
                result.replace(".0", "")  // Elimina el .0 si es un número entero
            } else {
                result
            }

            _secondaryDisplay.value = "$operand $currentOperator $currentInput"
            _mainDisplay.value = formattedResult
            currentInput = formattedResult
            operand = ""
            currentOperator = ""
        }
    }

    fun onClearClick() {
        currentInput = ""
        operand = ""
        currentOperator = ""
        _mainDisplay.value = "0"
        _secondaryDisplay.value = ""
    }

    fun onDeleteClick() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            _mainDisplay.value = if (currentInput.isEmpty()) "0" else currentInput
        }
    }

    fun onPercentClick() {
        if (currentInput.isNotEmpty()) {
            currentInput = calculator.calculatePercentage(currentInput)
            _mainDisplay.value = currentInput
        }
    }
}
