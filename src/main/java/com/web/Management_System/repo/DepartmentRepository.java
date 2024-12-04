package com.web.Management_System.repo;

import com.web.Management_System.model.DepartmentModel;
import com.web.Management_System.repo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByName(String name);
}
