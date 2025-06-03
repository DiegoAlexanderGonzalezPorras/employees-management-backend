package co.com.employees.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "access_request")
public class AccessRequest {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request", referencedColumnName = "id")
    private Request request;

    @Column(name = "name")
    private String username;

    @Column
    private String access;  
}
