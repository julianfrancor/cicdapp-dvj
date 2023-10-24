package com.eafit.calculatordvj

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun contextLoads() {
    }

    private fun getRequest(url: String): String {
        val fullUrl = "http://localhost:$port$url"
        val response: ResponseEntity<String> = restTemplate.getForEntity(fullUrl, String::class.java)
        return response.body ?: ""
    }

    @Test
    fun testIndexWithNameParam() {
        val response = getRequest("/api/?name=John")
        assert(response.contains("Hello, John!"))
    }

    @Test
    fun testHelloWithNameParam() {
        val response = getRequest("/api/hello?name=Jane")
        assert(response.contains("Hello Jane!"))
    }

    @Test
    fun testHelloWithoutNameParam() {
        val response = getRequest("/api/hello")
        assert(response.contains("Hello World!"))
    }

    @Test
    fun testSquare() {
        val response = getRequest("/api/square?firstNumber=5")
        assert(response.contains("The square of 5.0 is 25.0"))
    }

    @Test
    fun testCube() {
        val response = getRequest("/api/cube?firstNumber=3")
        assert(response.contains("The cube of 3.0 is 27.0"))
    }

    @Test
    fun testSum() {
        val response = getRequest("/api/sum?firstNumber=10&secondNumber=7")
        assert(response.contains("The sum of 10.0 and 7.0 is 17.0"))
    }

    @Test
    fun testSubtract() {
        val response = getRequest("/api/subtract?firstNumber=15&secondNumber=8")
        assert(response.contains("The difference of 15.0 and 8.0 is 7.0"))
    }
}
