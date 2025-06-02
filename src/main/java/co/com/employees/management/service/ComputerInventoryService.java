package co.com.employees.management.service;

import co.com.employees.management.model.ComputerInventory;
import co.com.employees.management.repository.ComputerInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerInventoryService {
    private final ComputerInventoryRepository computerInventoryRepository;

    public ComputerInventory saveComputer(ComputerInventory computerInventory) {
        return computerInventoryRepository.save(computerInventory);
    }

    public List<String> getComputersModels() {
        return computerInventoryRepository.getComputersModels();
    }

    public List<String> getComputersSerial(String model) {
        return computerInventoryRepository.getComputersSerialNumber(model);
    }
}
