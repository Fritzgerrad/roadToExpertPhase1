package org.frz.hrbuddy.repository;

import org.frz.hrbuddy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    public Location findByName(String name);
    public Location findById(int id);
}
