package co.com.employees.management.repository;

import co.com.employees.management.model.ComputerInventory;
import org.springframework.data.repository.CrudRepository;

public interface ComputerInventoryRepository extends CrudRepository<ComputerInventory, Integer> {
}
