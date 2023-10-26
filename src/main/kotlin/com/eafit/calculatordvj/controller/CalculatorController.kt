package com.eafit.calculatordvj.controller

import com.eafit.calculatordvj.model.Calculator
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
class CalculatorController {
    private var calculator: Calculator = Calculator()

    companion object {
        private const val GREETING = "Hello"
    }

    @GetMapping(value = ["/index"], produces = [MediaType.TEXT_HTML_VALUE])
    fun serveHtml(): ResponseEntity<ByteArray> {
        val resource = ClassPathResource("templates/index.html")
        val inputStream = resource.inputStream.readBytes()

        return ResponseEntity
            .ok()
            .contentType(MediaType.TEXT_HTML)
            .body(inputStream)
    }

    // Endpoint: /
    // Description: Displays a welcome message...
    // Example: http://localhost:5000/api/?name=John
    @GetMapping("/")
    fun index(): String {
        return GREETING
    }

    // Endpoint: /hello
    // Parameters: name (optional)
    // Description: Greets the user with the provided name or a default greeting if no name is provided.
    // Example: http://localhost:5000/api/hello?name=John
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return "Hello $name!"
    }

    // Endpoint: /square
    // Parameters: firstNumber (optional, defaults to 0)
    // Description: Calculates and returns the square of the provided number.
    // Example: http://localhost:5000/api/square?firstNumber=5
    @GetMapping("/square")
    fun square(@RequestParam(value = "firstNumber", defaultValue = "0") firstNumber: Double): String {
        return "The square of $firstNumber is ${calculator.square(firstNumber)}"
    }

    // Endpoint: /cube
    // Parameters: firstNumber (optional, defaults to 0)
    // Description: Calculates and returns the cube of the provided number.
    // Example: http://localhost:5000/api/cube?firstNumber=3
    @GetMapping("/cube")
    fun cube(@RequestParam(value = "firstNumber", defaultValue = "0") firstNumber: Double): String {
        return "The cube of $firstNumber is ${calculator.cube(firstNumber)}"
    }

    // Endpoint: /sum
    // Parameters: firstNumber (optional, defaults to 0), secondNumber (optional, defaults to 0)
    // Description: Calculates and returns the sum of the provided numbers.
    // Example: http://localhost:5000/api/sum?firstNumber=10&secondNumber=7
    @GetMapping("/sum")
    fun sum(
        @RequestParam(value = "firstNumber", defaultValue = "0") firstNumber: Double,
        @RequestParam(value = "secondNumber", defaultValue = "0") secondNumber: Double
    ): String {
        return "The sum of $firstNumber and $secondNumber is ${calculator.sum(firstNumber, secondNumber)}"
    }

    // Endpoint: /subtract
    // Parameters: firstNumber (optional, defaults to 0), secondNumber (optional, defaults to 0)
    // Description: Calculates and returns the difference between the provided numbers.
    // Example: http://localhost:5000/api/subtract?firstNumber=15&secondNumber=8
    @GetMapping("/subtract")
    fun subtract(
        @RequestParam(value = "firstNumber", defaultValue = "0") firstNumber: Double,
        @RequestParam(value = "secondNumber", defaultValue = "0") secondNumber: Double
    ): String {
        return "The difference of $firstNumber and $secondNumber is ${calculator.subtract(firstNumber, secondNumber)}"
    }
}
