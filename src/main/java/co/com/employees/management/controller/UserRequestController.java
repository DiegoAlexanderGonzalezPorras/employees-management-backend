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

    @PutMapping("")
    public ResponseEntity<UserRequest> updateUserRequest(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userRequestService.updateUserRequest(userRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<UserRecord>> getUserRecord(@RequestParam String state){
        return ResponseEntity.ok(userRequestService.getUserRecord(state));
    }

    @GetMapping("/id")
    public ResponseEntity<UserRequest> getUser(@RequestParam int id_request){
        return ResponseEntity.ok(userRequestService.getUser(id_request));
    }
}
