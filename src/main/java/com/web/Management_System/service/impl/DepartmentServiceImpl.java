package com.web.Management_System.service.impl;

import com.web.Management_System.exception.DepartmentException;
import com.web.Management_System.model.DepartmentModel;
import com.web.Management_System.repo.DepartmentRepository;
import com.web.Management_System.repo.entity.Department;
import com.web.Management_System.service.DepartmentService;
import com.web.Management_System.service.mapper.DepartmentMapper;
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
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentModel> list() {
        return departmentRepository.findAll().stream().map(departmentMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<DepartmentModel> findById(Long id) {
        return  Optional.of(departmentRepository.findById(id).map(departmentMapper::toModel)
                .orElseThrow(() -> new RuntimeException("no department found with this id : " + id )));
    }

    @Override
    public DepartmentModel add(DepartmentModel departmentModel) {
        if (departmentRepository.existsByName(departmentModel.getName())) {
            throw new DepartmentException("Department with the name '" + departmentModel.getName() + "' already exists.");
        }
        Department entity = departmentMapper.toEntity(departmentModel);
        Department savedDepartment = departmentRepository.save(entity);
        log.info("department saved successfully");
        return departmentMapper.toModel(savedDepartment);
    }

    @Override
    public DepartmentModel update(Long id, DepartmentModel departmentModel) {
        if(!departmentRepository.existsById(id)){
            log.error("No department found with this id: " + id);
            throw new RuntimeException("No department found with this id: " + id);
        }

        Department department = departmentMapper.toEntity(departmentModel);
        department.setId(id);
        Department update = departmentRepository.save(department);
        return departmentMapper.toModel(update);
    }

    @Override
    public void delete(Long id) {
        if(!departmentRepository.existsById(id)){
            log.error("No department found with this id: " + id);
        }else{
            departmentRepository.deleteById(id);
        }
    }

}
