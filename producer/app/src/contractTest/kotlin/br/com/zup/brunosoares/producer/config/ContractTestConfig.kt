package br.com.zup.brunosoares.producer.config

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import kotlin.test.BeforeTest

@SpringBootTest
class ContractTestConfig {

    @Autowired
    private lateinit var mockmvc: MockMvc

    @BeforeTest
    fun setup() {
        RestAssuredMockMvc.mockMvc(mockmvc)
    }

}