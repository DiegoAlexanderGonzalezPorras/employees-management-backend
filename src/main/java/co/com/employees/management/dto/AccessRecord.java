package co.com.employees.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AccessRecord {
    private int id;
    private String name;
    private String access;
    private String state;
}
