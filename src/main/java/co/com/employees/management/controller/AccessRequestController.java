package co.com.employees.management.controller;

import co.com.employees.management.dto.AccessRecord;
import co.com.employees.management.model.AccessRequest;
import co.com.employees.management.service.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("access-request")
@RequiredArgsConstructor
public class AccessRequestController {
    private final AccessRequestService accessRequestService;

    @PostMapping("")
    public ResponseEntity<AccessRequest> createAccessRequest(@RequestBody AccessRequest accessRequest){
        return ResponseEntity.ok(accessRequestService.saveAccessRequest(accessRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<AccessRecord>> getAccessRecord(){
        return ResponseEntity.ok(accessRequestService.getAccessRecord());
    }
}
