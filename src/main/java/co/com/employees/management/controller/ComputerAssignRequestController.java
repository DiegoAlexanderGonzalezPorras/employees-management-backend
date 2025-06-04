package co.com.employees.management.controller;

import co.com.employees.management.dto.ComputerAssignRecord;
import co.com.employees.management.model.ComputerAssignRequest;
import co.com.employees.management.service.ComputerAssignRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer-assign-request")
@RequiredArgsConstructor
public class ComputerAssignRequestController {
    private final ComputerAssignRequestService computerAssignRequestService;

    @PostMapping("")
    public ResponseEntity<ComputerAssignRequest> createComputerAssignRequest(@RequestBody ComputerAssignRequest computerAssignRequest){
        return ResponseEntity.ok(computerAssignRequestService.saveComputerAssignRequest(computerAssignRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<ComputerAssignRecord>> getComputerAssignRecord(@RequestParam String state){
        return ResponseEntity.ok(computerAssignRequestService.getComputerAssignRecord(state));
    }
}
