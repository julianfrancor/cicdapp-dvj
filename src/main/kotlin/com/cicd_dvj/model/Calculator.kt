package com.cicd_dvj.model

class Calculator {
    fun cuadrado(numero: Double): Double {
        return numero * numero
    }

    fun cubo(numero: Double): Double {
        return numero * numero * numero
    }

    fun sum(number1: Double, number2: Double): Double {
        return number1 + number2
    }

    fun subtract(number1: Double, number2: Double): Double {
        return number1 - number2
    }
}