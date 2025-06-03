package co.com.employees.management.service;

import co.com.employees.management.enums.StateEnum;
import co.com.employees.management.model.AccessRequest;
import co.com.employees.management.model.Request;
import co.com.employees.management.repository.AccessRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccessRequestService {
    private final AccessRequestRepository accessRequestRepository;

    public AccessRequest saveAccessRequest(AccessRequest accessRequest) {
        Request request = new Request();
        request.setState(StateEnum.PENDIENTE.getIdState());

        accessRequest.setRequest(request);

        return accessRequestRepository.save(accessRequest);
    }
}
