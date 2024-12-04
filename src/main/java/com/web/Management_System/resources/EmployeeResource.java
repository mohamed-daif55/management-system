package com.web.Management_System.resources;

import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> list(){
        return employeeService.list();
    }

    @GetMapping("id/{id}")
    public Optional<EmployeeModel> findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeModel add(@RequestBody EmployeeModel employeeModel){
        return employeeService.add(employeeModel);
    }

    @PutMapping("{id}")
    public EmployeeModel update(@PathVariable Long id,@RequestBody EmployeeModel employeeModel){
        return employeeService.update(id, employeeModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

}
