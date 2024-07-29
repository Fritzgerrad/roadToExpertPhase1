package org.frz.hrbuddy.service;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.DepartmentDto;
import org.frz.hrbuddy.model.Department;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.repository.DepartmentRepository;
import org.frz.hrbuddy.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(DepartmentDto departmentDto) {
        Department department = Department.builder()
                .name(departmentDto.getName())
                .shortCode(departmentDto.getShortCode())
                .description(departmentDto.getDescription())
                .location(locationRepository.findById(departmentDto.getLocationId()))
                .active(true)
                .build();
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id);
        department.setName(departmentDto.getName());
        department.setShortCode(departmentDto.getShortCode());
        department.setDescription(departmentDto.getDescription());
        department.setLocation(locationRepository.findById(departmentDto.getLocationId()));
        return departmentRepository.save(department);
    }

    public void changeDepartmentStatus(int id, boolean isActive) {
        Department department = departmentRepository.findById(id);
        department.setActive(isActive);
        departmentRepository.save(department);
    }

    public double setDepartmentBudget(int id, double budget) {
        Department department = departmentRepository.findById(id);
        department.setBudget(budget);
        departmentRepository.save(department);
        return budget;
    }

    public Staff setDepartmentManager(int id, Staff staff) {
        Department department = departmentRepository.findById(id);
        department.setManager(staff);
        departmentRepository.save(department);
        return staff;
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
