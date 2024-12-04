package com.web.Management_System.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private Long id;

    private String name;

    private String email;

    private DepartmentModel departmentModel;
}
