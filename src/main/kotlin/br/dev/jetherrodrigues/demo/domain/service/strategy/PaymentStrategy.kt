package br.dev.jetherrodrigues.demo.domain.service.strategy

import br.dev.jetherrodrigues.demo.domain.entities.PaymentType
import br.dev.jetherrodrigues.demo.domain.entities.TicketPayment
import org.springframework.plugin.core.Plugin

interface PaymentStrategy : Plugin<TicketPayment> {
    fun performPayment(value: TicketPayment)
}

class CreditPaymentStrategy : PaymentStrategy {
    override fun performPayment(value: TicketPayment) {
        println("Executing credit payment for [ $value ]!")
    }

    override fun supports(ticketPayment: TicketPayment): Boolean =
        ticketPayment.type == PaymentType.CREDIT
}

class DebitPaymentStrategy : PaymentStrategy {
    override fun performPayment(value: TicketPayment) {
        println("Executing debit payment for [ $value ]!")
    }

    override fun supports(ticketPayment: TicketPayment): Boolean =
        ticketPayment.type == PaymentType.DEBIT
}
