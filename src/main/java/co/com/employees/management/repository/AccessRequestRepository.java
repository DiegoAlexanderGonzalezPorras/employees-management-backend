package co.com.employees.management.repository;

import co.com.employees.management.dto.AccessRecord;
import co.com.employees.management.model.AccessRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccessRequestRepository extends CrudRepository<AccessRequest, Integer> {

    AccessRequest findAllByRequestId(int id_request);

    @Query("SELECT r.id, r.date, a.username, a.access, s.name state FROM AccessRequest a" +
            "   JOIN Request r ON r.id = a.request.id" +
            "   LEFT JOIN State s ON r.state = s.id" +
            "   ORDER BY r.date DESC")
    List<AccessRecord> getAccessRecord();
}
