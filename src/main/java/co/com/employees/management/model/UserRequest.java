package co.com.employees.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_request")
public class UserRequest {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request", referencedColumnName = "id")
    private Request request;

    @Column
    private String identityNumber;

    @Column
    private String identityType;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String area;

    @Column
    private String rol;
}
