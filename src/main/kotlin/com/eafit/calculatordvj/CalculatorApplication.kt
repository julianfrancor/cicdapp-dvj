package com.eafit.calculatordvj

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CalculatorApplication

fun main(args: Array<String>) {
    SpringApplication.run(CalculatorApplication::class.java, *args)
}
