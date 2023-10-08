package br.dev.jetherrodrigues.demo.application.config

import br.dev.jetherrodrigues.demo.domain.service.strategy.CreditPaymentStrategy
import br.dev.jetherrodrigues.demo.domain.service.strategy.DebitPaymentStrategy
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentStrategyConfig {
    @Bean
    @Qualifier("creditPaymentStrategy")
    fun creditPaymentStrategy() = CreditPaymentStrategy()

    @Bean
    @Qualifier("debitPaymentStrategy")
    fun debitPaymentStrategy() = DebitPaymentStrategy()
}
