package co.com.employees.management.controller;

import co.com.employees.management.dto.RequestDto;
import co.com.employees.management.model.Request;
import co.com.employees.management.service.RequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.Mockito.*;

public class RequestControllerTest {

    @InjectMocks
    private RequestController requestController;

    @Mock
    private RequestService requestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUserRequestTest(){
        Request request = new Request();
        request.setId(1);

        when(requestService.updateRequestState(any())).thenReturn(request);

        ResponseEntity<Request> requestRs = requestController.createUserRequest(null);

        Assertions.assertEquals(1, requestRs.getBody().getId());
    }
}
