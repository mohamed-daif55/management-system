package com.web.Management_System.service.mapper;

import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.repo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "departmentModel", target = "department")
    })
    Employee toEntity(EmployeeModel employeeModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "department", target = "departmentModel")
    })
    EmployeeModel toModel(Employee employee);

}
