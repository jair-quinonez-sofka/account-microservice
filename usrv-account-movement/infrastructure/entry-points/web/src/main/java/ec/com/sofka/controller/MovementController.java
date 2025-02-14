package ec.com.sofka.controller;


import ec.com.sofka.data.AccountDTO;
import ec.com.sofka.data.MovementDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.handlers.MovementHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movements")
public class MovementController {
    private final MovementHandler movementHandler;


    public MovementController(MovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<MovementResponseDTO> create(@Valid @RequestBody MovementDTO movementDTO) {
        return ResponseEntity.ok(movementHandler.createMovement(movementDTO));
    }
}
