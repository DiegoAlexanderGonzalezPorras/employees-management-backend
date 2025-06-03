package co.com.employees.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRecord {
    private String identityNumber;
    private String name;
    private String area;
    private String rol;
    private String state;
}
