package co.com.employees.management.controller;

import co.com.employees.management.dto.AccessRecord;
import co.com.employees.management.model.AccessRequest;
import co.com.employees.management.service.AccessRequestService;
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

public class AccessRequestControllerTest {

    @InjectMocks
    private AccessRequestController accessRequestController;

    @Mock
    private AccessRequestService accessRequestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAccessRequestTest(){
        AccessRequest accessRequestRq = new AccessRequest();
        accessRequestRq.setId(1);

        when(accessRequestService.saveAccessRequest(any())).thenReturn(accessRequestRq);

        ResponseEntity<AccessRequest> accessRequestRs = accessRequestController.createAccessRequest(null);

        Assertions.assertEquals(1, accessRequestRs.getBody().getId());
    }

    @Test
    public void getAccessRecordTest(){
        AccessRecord accessRecordRq = new AccessRecord();
        accessRecordRq.setId(1);

        List<AccessRecord> accessRecordList = new ArrayList<>();
        accessRecordList.add(accessRecordRq);

        when(accessRequestService.getAccessRecord()).thenReturn(accessRecordList);

        ResponseEntity<List<AccessRecord>> accessRecord = accessRequestController.getAccessRecord();

        Assertions.assertEquals(1, accessRecord.getBody().get(0).getId());
    }
}
