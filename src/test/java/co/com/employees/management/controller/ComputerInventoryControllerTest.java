package co.com.employees.management.controller;

import co.com.employees.management.model.ComputerInventory;
import co.com.employees.management.service.ComputerInventoryServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ComputerInventoryControllerTest {

    @InjectMocks
    private ComputerInventoryController computerInventoryController;

    @Mock
    private ComputerInventoryServiceTest computerInventoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createComputerTest(){
        ComputerInventory computerInventory = new ComputerInventory();
        computerInventory.setId(1);

        when(computerInventoryService.saveComputer(any())).thenReturn(computerInventory);

        ResponseEntity<ComputerInventory> computerAssignRequestRs = computerInventoryController.createComputer(null);

        Assertions.assertEquals(1, computerAssignRequestRs.getBody().getId());
    }

    @Test
    public void getComputersModelsTest(){
        String model = "1234";

        List<String> computersModels = new ArrayList<>();
        computersModels.add(model);

        when(computerInventoryService.getComputersModels()).thenReturn(computersModels);

        ResponseEntity<List<String>> models = computerInventoryController.getComputersModels();

        Assertions.assertEquals("1234", models.getBody().get(0));
    }

    @Test
    public void getComputerAssignRecordTest(){
        ComputerInventory computerInventory = new ComputerInventory();
        computerInventory.setId(1);

        List<ComputerInventory> computerInventoryList = new ArrayList<>();
        computerInventoryList.add(computerInventory);

        when(computerInventoryService.getComputersSerial(anyString())).thenReturn(computerInventoryList);

        ResponseEntity<List<ComputerInventory>> computerInventoryRs = computerInventoryController.getComputersSerialNumber("model");

        Assertions.assertEquals(1, computerInventoryRs.getBody().get(0).getId());
    }
}
