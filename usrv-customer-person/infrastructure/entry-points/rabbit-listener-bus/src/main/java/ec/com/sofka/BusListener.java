package ec.com.sofka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.sofka.customer.Customer;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IBusMessageListener;
import ec.com.sofka.usecases.GetCustomerByIdentificationUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public Object receiveMessage(CustomerInfoRequestRecord request) {
        System.out.println("Received message: " + request);


        return !request.isInfo() ? getCustomerByIdentificationUseCase.apply(request.identification())
                .map(Customer::getCustomerId)
                .orElse("")
                : getCustomerByIdentificationUseCase.apply(request.identification())
                .map(customer -> new CustomerInfoRecord(customer.getCustomerId(), customer.getName()))
                .orElse(new CustomerInfoRecord("", ""));

    }

}
