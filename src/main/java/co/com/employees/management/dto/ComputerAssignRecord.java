package co.com.employees.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ComputerAssignRecord {
    private String name;
    private String model;
    private String serialNumber;
    private String state;
}
