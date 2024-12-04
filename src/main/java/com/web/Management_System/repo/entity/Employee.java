package com.web.Management_System.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Data
@Table(name ="employee")
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
