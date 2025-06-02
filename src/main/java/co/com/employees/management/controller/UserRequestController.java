package co.com.employees.management.controller;

import co.com.employees.management.model.UserRequest;
import co.com.employees.management.service.UserRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-request")
@RequiredArgsConstructor
public class UserRequestController {
    private final UserRequestService userRequestService;

    @PostMapping("")
    public ResponseEntity<UserRequest> createUserRequest(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userRequestService.saveUserRequest(userRequest));
    }
}
