package org.frz.hrbuddy.repository;

import org.frz.hrbuddy.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByName(String name);
    public Department findById(int id);
}
