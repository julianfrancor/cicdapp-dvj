package com.eafit.calculatordvj

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
    }

    @Test
    fun testIndexWithNameParam() {
        mockMvc.perform(get("/?name=John"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, John!"))
    }

    @Test
    fun testHelloWithNameParam() {
        mockMvc.perform(get("/hello?name=Jane"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello Jane!"))
    }

    @Test
    fun testHelloWithoutNameParam() {
        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello World!"))
    }

    @Test
    fun testSquare() {
        mockMvc.perform(get("/square?firstNumber=5"))
            .andExpect(status().isOk)
            .andExpect(content().string("The square of 5.0 is 25.0"))
    }

    @Test
    fun testCube() {
        mockMvc.perform(get("/cube?firstNumber=3"))
            .andExpect(status().isOk)
            .andExpect(content().string("The cube of 3.0 is 27.0"))
    }

    @Test
    fun testSum() {
        mockMvc.perform(get("/sum?firstNumber=10&secondNumber=7"))
            .andExpect(status().isOk)
            .andExpect(content().string("The sum of 10.0 and 7.0 is 17.0"))
    }

    @Test
    fun testSubtract() {
        mockMvc.perform(get("/subtract?firstNumber=15&secondNumber=8"))
            .andExpect(status().isOk)
            .andExpect(content().string("The difference of 15.0 and 8.0 is 7.0"))
    }
}
