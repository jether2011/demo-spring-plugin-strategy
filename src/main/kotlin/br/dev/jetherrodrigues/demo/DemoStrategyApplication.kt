package br.dev.jetherrodrigues.demo

import br.dev.jetherrodrigues.demo.domain.service.strategy.PaymentStrategy
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.plugin.core.config.EnablePluginRegistries

@SpringBootApplication
@EnablePluginRegistries(
	value = [
		PaymentStrategy::class
	]
)
class DemoStrategyApplication

fun main(args: Array<String>) {
	runApplication<DemoStrategyApplication>(*args)
}
