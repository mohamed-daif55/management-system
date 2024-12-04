package com.web.Management_System.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name ="department")
@DynamicUpdate
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Employee> employees;


}
