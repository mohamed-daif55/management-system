package com.web.Management_System.resources;

import com.web.Management_System.model.DepartmentModel;
import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.service.DepartmentService;
import com.web.Management_System.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentResource {

    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentModel> list(){
        return departmentService.list();
    }

    @GetMapping("id/{id}")
    public Optional<DepartmentModel> findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @PostMapping
    public DepartmentModel add(@RequestBody DepartmentModel departmentModel){
        return departmentService.add(departmentModel);
    }

    @PutMapping("{id}")
    public DepartmentModel update(@PathVariable Long id,@RequestBody DepartmentModel departmentModel){
        return departmentService.update(id, departmentModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        departmentService.delete(id);
    }

}
