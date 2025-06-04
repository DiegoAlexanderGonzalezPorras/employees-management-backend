package co.com.employees.management.service;

import co.com.employees.management.dto.AccessRecord;
import co.com.employees.management.enums.StateEnum;
import co.com.employees.management.model.AccessRequest;
import co.com.employees.management.model.Request;
import co.com.employees.management.model.UserRequest;
import co.com.employees.management.repository.AccessRequestRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    public AccessRequest updateAccessRequest(AccessRequest accessRequest) {
        AccessRequest originalRequest = accessRequestRepository.findById(accessRequest.getId()).get();

        accessRequest.setRequest(originalRequest.getRequest());

        return accessRequestRepository.save(accessRequest);
    }

    public List<AccessRecord> getAccessRecord(String state) {
        List<AccessRecord> accessRecord;

        if (state.isEmpty()) {
            accessRecord = accessRequestRepository.getAccessRecord();
        }else{
            accessRecord = accessRequestRepository.getAccessRecordByState(StateEnum.APROBADO.getIdStateNameState(state));
        }

        accessRecord = accessRecord.stream().map((AccessRecord record) -> {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode access = mapper.readValue(record.getAccess(), JsonNode.class);
                Iterator<String> fieldNames = access.fieldNames();

                List<String> accessList = new ArrayList<>();
                while (fieldNames.hasNext()) {
                    String key = fieldNames.next();
                    boolean value = access.get(key).asBoolean();

                    if (value){
                        accessList.add(key);
                    }
                }

                record.setAccess(String.join(",", accessList));

                return record;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        return accessRecord;
    }

    public AccessRequest getAccessRequestById(int id_request){
        return accessRequestRepository.findAllByRequestId(id_request);
    }
}
