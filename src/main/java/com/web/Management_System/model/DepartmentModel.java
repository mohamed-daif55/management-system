package com.web.Management_System.model;

import com.web.Management_System.repo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

    private Long id;

    private String name;

    private String Description;

    //private List<EmployeeModel> employeesModels ;

}
