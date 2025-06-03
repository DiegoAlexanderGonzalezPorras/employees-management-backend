package co.com.employees.management.repository;

import co.com.employees.management.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {
}
