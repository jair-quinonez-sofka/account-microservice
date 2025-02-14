package ec.com.sofka;


import ec.com.sofka.gateway.IBusMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusAdapter implements IBusMessage {
    private  final RabbitTemplate rabbitTemplate;
    private  final RabbitEnvProperties rabbitEnvProperties;

    public BusAdapter(RabbitTemplate rabbitTemplate, RabbitEnvProperties rabbitEnvProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitEnvProperties = rabbitEnvProperties;
    }


    @Override
    public String sendMessage(String message) {
       Object  response  = rabbitTemplate.convertSendAndReceive(rabbitEnvProperties.getCustomerExchange(),  rabbitEnvProperties.getCustomerRoutingKey(), message);
        if (response != null) {
            return response.toString();
        } else {
            return null;
        }
    }
}
