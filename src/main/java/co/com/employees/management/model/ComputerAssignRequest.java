package co.com.employees.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "computer_assign_request")
public class ComputerAssignRequest {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request", referencedColumnName = "id")
    private Request request;

    @Column(name = "id_computer")
    private int idComputer;

    @Column
    private String name;
}
