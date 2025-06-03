package co.com.employees.management.service;

import co.com.employees.management.dto.RequestDto;
import co.com.employees.management.enums.StateEnum;
import co.com.employees.management.model.Request;
import co.com.employees.management.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public Request updateRequestState(RequestDto requestDto) {
        Request request = requestRepository.findById(requestDto.getId()).get();
        request.setState(StateEnum.APROBADO.getIdStateNameState(requestDto.getState()));

        return requestRepository.save(request);
    }
}
