package com.eafit.calculatordvj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CalculatorApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<CalculatorApplication>(*args)
}
