package co.com.employees.management.repository;

import co.com.employees.management.model.ComputerInventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerInventoryRepository extends CrudRepository<ComputerInventory, Integer> {

    @Query("SELECT DISTINCT c.model FROM ComputerInventory c WHERE c.computerState = 1")
    List<String> getComputersModels();

    @Query("SELECT c FROM ComputerInventory c WHERE c.model = ?1 AND c.computerState = 1")
    List<ComputerInventory> getComputersSerialNumber(String model);

    @Modifying
    @Query("UPDATE ComputerInventory c SET c.computerState = :state WHERE c.id = :id")
    void updateComputerState(int id, int state);
}
