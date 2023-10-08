# Getting Started

To execute this project, just run the `DemoStrategyApplication` main class.

To test, execute the `cURL` bellow:
```bash
curl --location 'http://localhost:9090/v1/api/tickets/pay' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json'
--data '{
    "amount": 100.00,
    "paymentType": "DEBIT"
}'
```

The values allowed for payment type are `CREDIT` and `DEBIT`, you can try both.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)

