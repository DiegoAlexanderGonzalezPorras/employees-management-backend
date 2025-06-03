package co.com.employees.management.service;

import co.com.employees.management.dto.UserRecord;
import co.com.employees.management.enums.StateEnum;
import co.com.employees.management.model.Request;
import co.com.employees.management.model.UserRequest;
import co.com.employees.management.repository.UserRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRequestService {
    private final UserRequestRepository userRequestRepository;

    public UserRequest saveUserRequest(UserRequest userRequest) {
        Request request = new Request();
        request.setState(StateEnum.PENDIENTE.getIdState());

        userRequest.setRequest(request);

        return userRequestRepository.save(userRequest);
    }

    public List<UserRecord> getUserRecord(){
        return userRequestRepository.getUserRecord();
    }
}
