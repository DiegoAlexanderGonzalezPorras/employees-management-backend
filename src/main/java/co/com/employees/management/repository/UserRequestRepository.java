package co.com.employees.management.repository;

import co.com.employees.management.dto.UserRecord;
import co.com.employees.management.model.UserRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRequestRepository extends CrudRepository<UserRequest, Integer> {

    UserRequest findAllByRequestId(int id_request);

    @Query("SELECT r.id, u.identityNumber, u.name, u.area, u.rol, s.name state FROM UserRequest u" +
            "   JOIN Request r ON r.id = u.request.id" +
            "   LEFT JOIN State s on r.state = s.id")
    List<UserRecord> getUserRecord();
}
