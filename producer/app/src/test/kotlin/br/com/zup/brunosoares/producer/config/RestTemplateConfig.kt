package br.com.zup.brunosoares.producer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.client.RestTemplate
import org.springframework.web.context.WebApplicationContext

@Configuration
class RestTemplateConfig(private val webApplicationContext: WebApplicationContext) {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun mockMvcConfig() = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
}