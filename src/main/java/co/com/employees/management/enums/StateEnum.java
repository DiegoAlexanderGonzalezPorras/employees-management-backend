package co.com.employees.management.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum StateEnum {
    APROBADO("APROBADO", 1),
    PENDIENTE("PENDIENTE", 2),
    RECHAZADO("RECHAZADO", 3),
    CANCELADO("CANCELADO", 4);

    private final String nameState;
    private final int idState;

    public int getIdStateNameState(String nameState) {
        StateEnum state = Arrays.stream(StateEnum.values())
                .filter(item -> item.getNameState().equals(nameState))
                .findFirst().orElse(StateEnum.PENDIENTE);

        return state.getIdState();
    }
}
