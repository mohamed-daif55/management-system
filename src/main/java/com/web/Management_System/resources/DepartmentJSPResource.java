package com.web.Management_System.resources;

import com.web.Management_System.model.DepartmentModel;
import com.web.Management_System.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("departmentsJSP")
@RequiredArgsConstructor
public class DepartmentJSPResource {

    private final DepartmentService departmentService;

    @GetMapping
    public String list(Model model) {
        List<DepartmentModel> departments = departmentService.list();
        model.addAttribute("departments", departments);
        return "department-list";
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<DepartmentModel> department = departmentService.findById(id);
        if (department.isPresent()) {
            model.addAttribute("department", department.get());
            return "department-detail";
        }
        return "department-not-found";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new DepartmentModel());
        return "department-form";
    }

    @PostMapping
    public String add(@ModelAttribute DepartmentModel departmentModel) {
        departmentService.add(departmentModel);
        return "redirect:/departmentsJSP";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<DepartmentModel> department = departmentService.findById(id);
        if (department.isPresent()) {
            model.addAttribute("department", department.get());
            return "department-form";
        }
        return "department-not-found";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute DepartmentModel departmentModel) {
        departmentService.update(id, departmentModel);
        return "redirect:/departmentsJSP";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/departmentsJSP";
    }

}
