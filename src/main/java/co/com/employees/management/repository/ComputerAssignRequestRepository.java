package co.com.employees.management.repository;

import co.com.employees.management.dto.ComputerAssignRecord;
import co.com.employees.management.model.ComputerAssignRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerAssignRequestRepository extends CrudRepository<ComputerAssignRequest, Integer> {

    @Query("SELECT r.id, c.name, ci.model, ci.serialNumber, s.name state FROM ComputerAssignRequest c" +
            "    JOIN Request r ON r.id = c.request.id" +
            "    LEFT JOIN ComputerInventory ci ON ci.id = c.idComputer" +
            "    LEFT JOIN State s ON r.state = s.id")
    List<ComputerAssignRecord> getComputerAssignRecord();
}
