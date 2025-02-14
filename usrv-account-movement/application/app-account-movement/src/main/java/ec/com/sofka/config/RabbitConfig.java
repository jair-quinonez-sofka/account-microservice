package ec.com.sofka.config;


import ec.com.sofka.RabbitEnvProperties;
import org.springframework.amqp.core.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    private final RabbitEnvProperties envProperties;

    public RabbitConfig(RabbitEnvProperties envProperties) {
        this.envProperties = envProperties;
    }

    @Bean
    public TopicExchange customerExchange() {
        return new TopicExchange(envProperties.getCustomerExchange(), true, false);
    }


    @Bean
    public Queue customerQueue() {
        return new Queue(envProperties.getCustomerQueue(), true);
    }

    @Bean
    public Binding accountBinding() {
        return BindingBuilder.bind(customerQueue())
                .to(customerExchange())
                .with(envProperties.getCustomerRoutingKey());
    }



    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeBeans(AmqpAdmin amqpAdmin) {
        return event -> {


            amqpAdmin.declareExchange(customerExchange());
            amqpAdmin.declareQueue(customerQueue());
            amqpAdmin.declareBinding(accountBinding());
        };
    }

}
