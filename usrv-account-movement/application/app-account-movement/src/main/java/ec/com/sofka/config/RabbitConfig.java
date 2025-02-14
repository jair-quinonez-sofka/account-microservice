package ec.com.sofka.config;


import ec.com.sofka.RabbitEnvProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplateBean(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }



}
