package com.web.Management_System.service;

import com.web.Management_System.model.DepartmentModel;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<DepartmentModel> list();

    Optional<DepartmentModel> findById(Long id);

    DepartmentModel add(DepartmentModel departmentModel);

    DepartmentModel update(Long id, DepartmentModel departmentModel);

    void delete(Long id);
}
