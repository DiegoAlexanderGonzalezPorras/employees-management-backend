package co.com.employees.management.repository;

import co.com.employees.management.model.AccessRequest;
import org.springframework.data.repository.CrudRepository;

public interface AccessRequestRepository extends CrudRepository<AccessRequest, Integer> {
}
