package com.web.Management_System.service.mapper;

import com.web.Management_System.model.DepartmentModel;
import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.repo.entity.Department;
import com.web.Management_System.repo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
           // @Mapping(source = "employeesModels", target = "employees")
    })
    Department toEntity(DepartmentModel departmentModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
           // @Mapping(source = "employees", target = "employeesModels")
    })
    DepartmentModel toModel(Department department);

}
