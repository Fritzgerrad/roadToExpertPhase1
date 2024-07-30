package org.frz.hrbuddy.repository;

import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findByUser(User user);
}
