package ec.com.sofka.controller;


import ec.com.sofka.customer.Customer;
import ec.com.sofka.data.CustomerDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.handlers.CustomerHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerHandler.createCustomer(customerDTO));
    }
}
