package co.com.employees.management.controller;

import co.com.employees.management.model.ComputerInventory;
import co.com.employees.management.service.ComputerInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer-inventory")
@RequiredArgsConstructor
public class ComputerInventoryController {
    private final ComputerInventoryService computerInventoryService;

    @PostMapping("")
    public ResponseEntity<ComputerInventory> createComputer(@RequestBody ComputerInventory computerInventory){
        return ResponseEntity.ok(computerInventoryService.saveComputer(computerInventory));
    }

    @GetMapping("/models")
    public ResponseEntity<List<String>> getComputersModels(){
        return ResponseEntity.ok(computerInventoryService.getComputersModels());
    }

    @GetMapping("/serial-number")
    public ResponseEntity<List<String>> getComputersSerialNumber(@RequestParam String model){
        return ResponseEntity.ok(computerInventoryService.getComputersSerial(model));
    }
}
