package br.dev.jetherrodrigues.demo.application.web

import br.dev.jetherrodrigues.demo.domain.entities.PaymentType
import br.dev.jetherrodrigues.demo.domain.entities.TicketPayment
import br.dev.jetherrodrigues.demo.domain.service.PaymentService
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@Validated
@RestController
@RequestMapping("/v1/api/tickets")
internal class DemoStrategyController(private val paymentService: PaymentService) {
    @PostMapping("/pay")
    fun pay(@RequestBody ticketPaymentRequest: TicketPaymentRequest): ResponseEntity<TicketPaymentResponse> =
        ticketPaymentRequest.to().let { payment ->
            paymentService.processPayment(payment).let {
                ResponseEntity
                    .accepted()
                    .body(TicketPaymentResponse.from(payment))
            }
        }
}

internal data class TicketPaymentRequest(
    @NotNull
    @Positive
    val amount: BigDecimal,
    @NotNull
    val paymentType: PaymentType
) {
    fun to() = TicketPayment(type = paymentType, amount = amount)
}

internal data class TicketPaymentResponse(val authorizationCode: String) {
    companion object {
        fun from(payment: TicketPayment) = TicketPaymentResponse(payment.authorizationCode)
    }
}
