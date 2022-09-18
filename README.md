# Logging Consumer Example app to reproduce a bug that was contained on [Spring Cloud Function](https://github.com/spring-cloud/spring-cloud-function/issues/918)

## Message published on the SCF issue project

### Describe the issue
While consuming an event using Kotlin + data classes + Spring Cloud Function and the payload can not be correctly parsed the framework does not throw a MessageConversionException or a ClassCastException, rather the exception is swollen null is returned in the internals, the message is consumed and no DLQ message is published.

I attached an example re-creating the same situation in the official documentation here to prove this issue while using Kotlin + Spring Cloud Function + Spring Cloud Stream.

### To Reproduce
Steps to reproduce the behavior:

1. You need to have a RabbitMQ locally running
2. Start the example attached
3. Go to the RabbitMQ management console or any other RabbitMQ client and send a message to [log-in-0.loggingconsumer
4. The contents of the message should be a wrongly JSON representation of the Person class, as follows {"name":[]}
5. No error is shown, the message is consumed and no message is published to the DLQ

### Version of the framework
- spring-boot: 2.7.2
- spring cloud stream: 3.2.4
- Kotlin: 1.6.21

### Expected behavior
An exception should be throw when the parsing of the message is impossible