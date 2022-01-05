package br.com.zup.brunosoares.producer

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EvenOddController(private val evenOddService: EvenOddService) {
    @GetMapping("/validate/prime/{number}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun isPrime(@PathVariable("number") number: Int) =
        evenOddService.isPrime(number)
}

@Service
class EvenOddService {
    fun isPrime(number: Int) = if (number % 2 == 0) "Even" else "Odd"
}