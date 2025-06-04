package co.com.employees.management.service;

import co.com.employees.management.dto.ComputerAssignRecord;
import co.com.employees.management.enums.ComputerStateEnum;
import co.com.employees.management.enums.StateEnum;
import co.com.employees.management.model.ComputerAssignRequest;
import co.com.employees.management.model.Request;
import co.com.employees.management.repository.ComputerAssignRequestRepository;
import co.com.employees.management.repository.ComputerInventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerAssignRequestService {
    private final ComputerAssignRequestRepository computerAssignRequestRepository;
    private final ComputerInventoryRepository computerInventoryRepository;

    @Transactional
    public ComputerAssignRequest saveComputerAssignRequest(ComputerAssignRequest computerAssignRequest) {
        Request request = new Request();
        request.setState(StateEnum.PENDIENTE.getIdState());

        computerAssignRequest.setRequest(request);

        computerInventoryRepository.updateComputerState(computerAssignRequest.getIdComputer(), ComputerStateEnum.EN_USO.getIdState());
        return computerAssignRequestRepository.save(computerAssignRequest);
    }

    public List<ComputerAssignRecord> getComputerAssignRecord(String state) {
        if (state.isEmpty()) {
            return computerAssignRequestRepository.getComputerAssignRecord();
        } else {
            return computerAssignRequestRepository.getComputerAssignRecordByState(StateEnum.APROBADO.getIdStateNameState(state));
        }
    }
}
