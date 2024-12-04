package com.web.Management_System.service;

import com.web.Management_System.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeModel> list();

    Optional<EmployeeModel> findById(Long id);

    EmployeeModel add(EmployeeModel employeeModel);

    EmployeeModel update(Long id, EmployeeModel employeeModel);

    void delete(Long id);

}
