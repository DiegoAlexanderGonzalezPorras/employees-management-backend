package co.com.employees.management.repository;

import co.com.employees.management.model.UserRequest;
import org.springframework.data.repository.CrudRepository;

public interface UserRequestRepository extends CrudRepository<UserRequest, Integer> {
}
