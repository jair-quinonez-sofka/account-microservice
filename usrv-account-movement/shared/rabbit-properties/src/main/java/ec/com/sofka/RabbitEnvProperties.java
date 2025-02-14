package ec.com.sofka;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:rabbit-application.properties")
public class RabbitEnvProperties {

    @Value("${customer.exchange.name}")
    private String customerExchange;

    @Value("${customer.queue.name}")
    private String customerQueue;

    @Value("${customer.routing.key}")
    private String customerRoutingKey;


    public String getCustomerExchange() {
        return customerExchange;
    }

    public String getCustomerQueue() {
        return customerQueue;
    }

    public String getCustomerRoutingKey() {
        return customerRoutingKey;
    }
}
