package co.com.employees.management.controller;

import co.com.employees.management.dto.UserRecord;
import co.com.employees.management.model.UserRequest;
import co.com.employees.management.service.UserRequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserRequestControllerTest {

    @InjectMocks
    private UserRequestController userRequestController;

    @Mock
    private UserRequestService userRequestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUserRequestTest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setId(1);

        when(userRequestService.saveUserRequest(any())).thenReturn(userRequest);

        ResponseEntity<UserRequest> computerAssignRequestRs = userRequestController.createUserRequest(null);

        Assertions.assertEquals(1, computerAssignRequestRs.getBody().getId());
    }

    @Test
    public void getUserRecordTest(){
        UserRecord userRecord = new UserRecord();
        userRecord.setId(1);

        List<UserRecord> userRecordList = new ArrayList<>();
        userRecordList.add(userRecord);

        when(userRequestService.getUserRecord(anyString())).thenReturn(userRecordList);

        ResponseEntity<List<UserRecord>> accessRecord = userRequestController.getUserRecord("");

        Assertions.assertEquals(1, accessRecord.getBody().get(0).getId());
    }
}
