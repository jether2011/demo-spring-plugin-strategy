package br.dev.jetherrodrigues.demo.application.config

import br.dev.jetherrodrigues.demo.domain.service.PaymentService
import br.dev.jetherrodrigues.demo.domain.service.strategy.PaymentStrategy
import br.dev.jetherrodrigues.demo.domain.entities.TicketPayment
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.plugin.core.PluginRegistry

@Configuration
class PaymentServiceConfig {
    @Bean
    fun paymentService(pluginRegistry: PluginRegistry<PaymentStrategy, TicketPayment>) =
        PaymentService(pluginRegistry)
}
