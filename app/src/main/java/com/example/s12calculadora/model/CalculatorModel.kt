package com.example.s12calculadora.model

class CalculatorModel {

    fun calculate(a: String, b: String, operator: String): String {
        val numA = a.toDoubleOrNull() ?: return "Error"
        val numB = b.toDoubleOrNull() ?: return "Error"

        return when (operator) {
            "+" -> (numA + numB).toString()
            "−" -> (numA - numB).toString()
            "×" -> (numA * numB).toString()
            "÷" -> if (numB != 0.0) (numA / numB).toString() else "Error"
            else -> "Error"
        }
    }

    fun calculatePercentage(value: String): String {
        return value.toDoubleOrNull()?.div(100)?.toString() ?: "Error"
    }
}
