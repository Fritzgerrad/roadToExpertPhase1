package org.frz.hrbuddy.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.StaffDto;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.service.StaffService;
import org.frz.hrbuddy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final StaffService staffService;

    @PostMapping("/new")
    public ResponseEntity<String> createStaff(@RequestBody StaffDto staffDto){
        String res = staffService.addStaff(staffDto);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable Long id, @RequestBody StaffDto staffDto){
        String res = staffService.editStaff(id,staffDto);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable Long id){
        Staff staff = staffService.findStaff(id);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/all-staff")
    public ResponseEntity<List<Staff>> getAllStaff(){
        return ResponseEntity.ok(staffService.findAllStaff());
    }

    @PutMapping("assign-supervisor")
    public ResponseEntity<String> assignSupervisor(@RequestParam Long staffId, @RequestParam Long supervisorId){
        String res = staffService.assignSupervisor(staffId,supervisorId);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStaff(@RequestParam Long staffId){
        String res = staffService.deleteStaff(staffId);
        return ResponseEntity.ok(res);
    }
}
