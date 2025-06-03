package co.com.employees.management.controller;

import co.com.employees.management.dto.UserRecord;
import co.com.employees.management.model.UserRequest;
import co.com.employees.management.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-request")
@RequiredArgsConstructor
public class UserRequestController {
    private final UserRequestService userRequestService;

    @PostMapping("")
    public ResponseEntity<UserRequest> createUserRequest(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userRequestService.saveUserRequest(userRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<UserRecord>> getUserRecord(){
        return ResponseEntity.ok(userRequestService.getUserRecord());
    }
}
