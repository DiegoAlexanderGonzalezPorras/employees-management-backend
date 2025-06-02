package co.com.employees.management.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StateEnum {
    APROBADO("APROBADO", 1),
    PENDIENTE("PENDIENTE", 2),
    RECHAZADO("RECHAZADO", 3),
    CANCELADO("CANCELADO", 4);

    private final String nameState;
    private final int idState;
}
