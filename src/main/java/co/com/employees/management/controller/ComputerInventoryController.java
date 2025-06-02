package co.com.employees.management.controller;

import co.com.employees.management.model.ComputerInventory;
import co.com.employees.management.service.ComputerInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer-inventory")
@RequiredArgsConstructor
public class ComputerInventoryController {
    private final ComputerInventoryService computerInventoryService;

    @PostMapping("")
    public ResponseEntity<ComputerInventory> createComputer(@RequestBody ComputerInventory computerInventory){
        return ResponseEntity.ok(computerInventoryService.saveComputer(computerInventory));
    }
}
