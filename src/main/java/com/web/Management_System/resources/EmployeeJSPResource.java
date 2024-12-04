package com.web.Management_System.resources;

import com.web.Management_System.model.EmployeeModel;
import com.web.Management_System.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employeesJSP")
@RequiredArgsConstructor
public class EmployeeJSPResource {

    private final EmployeeService employeeService;

    @GetMapping
    public String list(Model model) {
        List<EmployeeModel> employees = employeeService.list();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("id/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<EmployeeModel> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee-detail";
        }
        return "employee-not-found";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new EmployeeModel());
        return "employee-form";
    }

    @PostMapping
    public String add(@ModelAttribute EmployeeModel employeeModel) {
        employeeService.add(employeeModel);
        return "redirect:/employeesJSP";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<EmployeeModel> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee-form";
        }
        return "employee-not-found";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute EmployeeModel employeeModel) {
        employeeService.update(id, employeeModel);
        return "redirect:/employeesJSP";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employeesJSP";
    }

}
