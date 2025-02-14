package ec.com.sofka.controller;


import ec.com.sofka.data.AccountDTO;
import ec.com.sofka.data.AccountStatementResponseDTO;
import ec.com.sofka.handlers.AccountHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountHandler accountHandler;

    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountHandler.createAccount(accountDTO));
    }

    @GetMapping("/reports")
    public ResponseEntity<List<AccountStatementResponseDTO>> getReports(
            @RequestParam("date") String dateRange,
            @RequestParam("identification") String customerIdentification
    ) {
        return ResponseEntity.ok(accountHandler.getAccountStatements(dateRange, customerIdentification));

    }
}
