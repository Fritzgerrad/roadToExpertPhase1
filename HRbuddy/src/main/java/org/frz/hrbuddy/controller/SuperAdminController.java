package org.frz.hrbuddy.controller;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.DepartmentDto;
import org.frz.hrbuddy.dto.LocationDto;
import org.frz.hrbuddy.model.Department;
import org.frz.hrbuddy.model.Location;
import org.frz.hrbuddy.service.DepartmentService;
import org.frz.hrbuddy.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superAdmin")
public class SuperAdminController {
    private final DepartmentService departmentService;
    private final LocationService locationService;

    @PostMapping("/new-department")
    public ResponseEntity<Department> newDepartment(@RequestBody DepartmentDto department) {
        Department newDepartment = departmentService.createDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @PostMapping("/new-location")
    public ResponseEntity<Location> newLocation(@RequestBody LocationDto locationDto) {
        Location location = locationService.newLocation(locationDto);
        return ResponseEntity.ok(location);
    }
}
