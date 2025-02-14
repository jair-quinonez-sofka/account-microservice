package ec.com.sofka;


import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IBusMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BusAdapter implements IBusMessage {
    private  final RabbitTemplate rabbitTemplate;
    private  final RabbitEnvProperties rabbitEnvProperties;

    public BusAdapter(RabbitTemplate rabbitTemplate, RabbitEnvProperties rabbitEnvProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitEnvProperties = rabbitEnvProperties;
    }


    @Override
    public Object sendMessage(CustomerInfoRequestRecord  request) {


        Object response = rabbitTemplate.convertSendAndReceive(
                rabbitEnvProperties.getCustomerExchange(),
                rabbitEnvProperties.getCustomerRoutingKey(),
                request
        );


        System.out.println(response);

        if (response != null) {
            System.out.println(response.getClass().getName());

            if (response instanceof String) {
                return response.toString();
            }
            if (response instanceof LinkedHashMap) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.convertValue(response, CustomerInfoRecord.class);
            }

            if (response instanceof CustomerInfoRecord) {
                return response;
            }
        }
        return null;
    }
}
