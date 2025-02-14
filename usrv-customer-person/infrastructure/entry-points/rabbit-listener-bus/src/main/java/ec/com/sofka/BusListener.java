package ec.com.sofka;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.gateway.IBusMessageListener;
import ec.com.sofka.usecases.GetCustomerByIdentificationUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BusListener implements IBusMessageListener {
    private final RabbitEnvProperties envProperties;
    private final GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase;

    public BusListener(RabbitEnvProperties envProperties, GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase) {
        this.envProperties = envProperties;
        this.getCustomerByIdentificationUseCase = getCustomerByIdentificationUseCase;
    }

    @Override
    @RabbitListener(queues = "#{rabbitEnvProperties.getCustomerQueue()}")
    public String receiveMessage(String message) {
        System.out.println("Received message: " + message);


        return getCustomerByIdentificationUseCase.apply(message)
                .map(Customer::getCustomerId)
                .orElse("");
    }
}
