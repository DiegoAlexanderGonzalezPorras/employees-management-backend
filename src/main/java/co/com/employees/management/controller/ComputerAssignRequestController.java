package co.com.employees.management.controller;

import co.com.employees.management.model.ComputerAssignRequest;
import co.com.employees.management.service.ComputerAssignRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer-assign-request")
@RequiredArgsConstructor
public class ComputerAssignRequestController {
    private final ComputerAssignRequestService computerAssignRequestService;

    @PostMapping("")
    public ResponseEntity<ComputerAssignRequest> createComputerAssignRequest(@RequestBody ComputerAssignRequest computerAssignRequest){
        return ResponseEntity.ok(computerAssignRequestService.saveComputerAssignRequest(computerAssignRequest));
    }
}
