package com.web.Management_System.service.impl;

import com.web.Management_System.exception.EmployeeException;
import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.repo.EmployeeRepository;
import com.web.Management_System.repo.entity.Employee;
import com.web.Management_System.service.EmployeeService;
import com.web.Management_System.service.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeModel> list() {
        return employeeRepository.findAll().stream().map(employeeMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        return  Optional.of(employeeRepository.findById(id).map(employeeMapper::toModel)
                .orElseThrow(() -> new RuntimeException("no employee found with this id : " + id )));
    }

    @Override
    public EmployeeModel add(EmployeeModel employeeModel) {
        if (employeeModel.getName() == null) {
            throw new EmployeeException("employee name is required");
        }

        if (employeeModel.getEmail() == null) {
            throw new EmployeeException("employee email is required");
        }

        if (employeeModel.getDepartmentModel() == null) {
            throw new EmployeeException("department ID is required");
        }

        if( employeeModel.getDepartmentModel().getId() == null){
            throw new EmployeeException("department ID is required");
        }

        Employee entity = employeeMapper.toEntity(employeeModel);
        Employee savedEmployee = employeeRepository.save(entity);
        log.info("employee saved successfully");
        return employeeMapper.toModel(savedEmployee);
    }

    @Override
    public EmployeeModel update(Long id, EmployeeModel employeeModel) {
        if(!employeeRepository.existsById(id)){
            log.error("No employee found with this id: " + id);
            throw new RuntimeException("No employee found with this id: " + id);
        }

        Employee employee = employeeMapper.toEntity(employeeModel);
        employee.setId(id);
        Employee update = employeeRepository.save(employee);
        return employeeMapper.toModel(update);
    }

    @Override
    public void delete(Long id) {
        if(!employeeRepository.existsById(id)){
            log.error("No employee found with this id: " + id);
        }else{
            employeeRepository.deleteById(id);
        }
    }
}
