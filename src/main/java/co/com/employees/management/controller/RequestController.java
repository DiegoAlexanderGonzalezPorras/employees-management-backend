package co.com.employees.management.controller;

import co.com.employees.management.dto.RequestDto;
import co.com.employees.management.model.Request;
import co.com.employees.management.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @PutMapping("/state")
    public ResponseEntity<Request> createUserRequest(@RequestBody RequestDto request){
        return ResponseEntity.ok(requestService.updateRequestState(request));
    }
}
