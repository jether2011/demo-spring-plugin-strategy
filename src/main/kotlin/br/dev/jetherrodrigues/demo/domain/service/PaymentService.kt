package br.dev.jetherrodrigues.demo.domain.service

import br.dev.jetherrodrigues.demo.domain.service.strategy.PaymentStrategy
import br.dev.jetherrodrigues.demo.domain.entities.TicketPayment
import org.springframework.plugin.core.PluginRegistry

class PaymentService(private val pluginRegistry: PluginRegistry<PaymentStrategy, TicketPayment>) {

    fun processPayment(payment: TicketPayment) {
        pluginRegistry.getPluginFor(payment).ifPresent { strategy ->
            strategy.performPayment(payment)
        }
    }
}
