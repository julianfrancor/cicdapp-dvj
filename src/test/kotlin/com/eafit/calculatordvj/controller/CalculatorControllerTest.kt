package com.eafit.calculatordvj.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(CalculatorController::class)
class CalculatorControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testIndexWithNameParam() {
        mockMvc.perform(get("/api/"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello"))
    }

    @Test
    fun testHelloWithNameParam() {
        mockMvc.perform(get("/api/hello?name=Jane"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello Jane!"))
    }

    @Test
    fun testHelloWithoutNameParam() {
        mockMvc.perform(get("/api/hello"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello World!"))
    }

    @Test
    fun testSquare() {
        mockMvc.perform(get("/api/square?firstNumber=5"))
            .andExpect(status().isOk)
            .andExpect(content().string("The square of 5.0 is 25.0"))
    }

    @Test
    fun testCube() {
        mockMvc.perform(get("/api/cube?firstNumber=3"))
            .andExpect(status().isOk)
            .andExpect(content().string("The cube of 3.0 is 27.0"))
    }

    @Test
    fun testSum() {
        mockMvc.perform(get("/api/sum?firstNumber=10&secondNumber=7"))
            .andExpect(status().isOk)
            .andExpect(content().string("The sum of 10.0 and 7.0 is 17.0"))
    }

    @Test
    fun testSubtract() {
        mockMvc.perform(get("/api/subtract?firstNumber=15&secondNumber=8"))
            .andExpect(status().isOk)
            .andExpect(content().string("The difference of 15.0 and 8.0 is 7.0"))
    }
}
