package co.com.employees.management.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ComputerStateEnum {
    HABILITADO("HABILITADO", 1),
    EN_USO("EN USO", 2);

    private final String nameState;
    private final int idState;
}
