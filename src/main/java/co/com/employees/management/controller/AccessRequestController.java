package co.com.employees.management.controller;

import co.com.employees.management.model.AccessRequest;
import co.com.employees.management.service.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("access-request")
@RequiredArgsConstructor
public class AccessRequestController {
    private final AccessRequestService accessRequestService;

    @PostMapping("")
    public ResponseEntity<AccessRequest> createAccessRequest(@RequestBody AccessRequest accessRequest){
        return ResponseEntity.ok(accessRequestService.saveAccessRequest(accessRequest));
    }
}
