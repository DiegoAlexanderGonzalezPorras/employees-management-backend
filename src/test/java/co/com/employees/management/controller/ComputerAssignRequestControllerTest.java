package co.com.employees.management.controller;

import co.com.employees.management.dto.ComputerAssignRecord;
import co.com.employees.management.model.ComputerAssignRequest;
import co.com.employees.management.service.ComputerAssignRequestService;
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

public class ComputerAssignRequestControllerTest {

    @InjectMocks
    private ComputerAssignRequestController accessRequestController;

    @Mock
    private ComputerAssignRequestService computerAssignRequestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createComputerAssignRequestTest(){
        ComputerAssignRequest computerAssignRequest = new ComputerAssignRequest();
        computerAssignRequest.setId(1);

        when(computerAssignRequestService.saveComputerAssignRequest(any())).thenReturn(computerAssignRequest);

        ResponseEntity<ComputerAssignRequest> computerAssignRequestRs = accessRequestController.createComputerAssignRequest(null);

        Assertions.assertEquals(1, computerAssignRequestRs.getBody().getId());
    }

    @Test
    public void getComputerAssignRecordTest(){
        ComputerAssignRecord accessRecordRq = new ComputerAssignRecord();
        accessRecordRq.setId(1);

        List<ComputerAssignRecord> ComputerAssignRecordList = new ArrayList<>();
        ComputerAssignRecordList.add(accessRecordRq);

        when(computerAssignRequestService.getComputerAssignRecord(anyString())).thenReturn(ComputerAssignRecordList);

        ResponseEntity<List<ComputerAssignRecord>> accessRecord = accessRequestController.getComputerAssignRecord("");

        Assertions.assertEquals(1, accessRecord.getBody().get(0).getId());
    }
}
