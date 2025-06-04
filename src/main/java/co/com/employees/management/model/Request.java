package co.com.employees.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(insertable = false, updatable = false)
    private String date;

    @Column(name = "id_state")
    private int state;
}
