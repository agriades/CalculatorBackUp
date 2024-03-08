package com.example.calculatorbackup

class Simple {
    fun calAdd(currentTotal : String, valueToAdd: String) = (currentTotal.toFloat() + valueToAdd.toFloat()).toString()
    fun calSubtract (currentTotal : String, valueToSubtract: String) = (currentTotal.toFloat() - valueToSubtract.toFloat()).toString()
    fun calMultiply (currentTotal: String, valueToMultiply: String) = (currentTotal.toFloat() * valueToMultiply.toFloat()).toString()
    fun calDivide (currentTotal: String, valueToDivide: String) = (currentTotal.toFloat() / valueToDivide.toFloat()).toString()
}