import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Even Odd controller contract"
    request {
        url = url("/validate/prime/2")
        method = GET
    }
    response {
        status = OK
        headers {
            header(CONTENT_TYPE, APPLICATION_JSON)
        }
        body = body(
            "Even"
        )
    }
}