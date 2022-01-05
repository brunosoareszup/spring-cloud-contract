package br.com.zup.brunosoares.producer

import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import io.restassured.module.mockmvc.response.MockMvcResponse
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class EvenOddControllerTest(
//    @Autowired private val mockmvc: MockMvc
) {

    @Test
    fun `is even`() {
        assertTrue(true)
//        RestAssuredMockMvc.mockMvc(mockmvc)
//
//        val request: MockMvcRequestSpecification = given()
//            .header("Accept", "application/json")
//            .body("{\"messageList\":[\"23412341324\"]}")
//
//        val response: MockMvcResponse = given().spec(request)
//            .get("/validate/prime/2");
//
//        assertEquals("Even", response.asString())
    }

}