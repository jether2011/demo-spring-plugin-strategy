package br.dev.jetherrodrigues.demo.domain.entities

import io.azam.ulidj.ULID
import java.math.BigDecimal

data class TicketPayment(
    val id: String = ULID.random(),
    val authorizationCode: String = ULID.random(),
    val type: PaymentType,
    val amount: BigDecimal
)
