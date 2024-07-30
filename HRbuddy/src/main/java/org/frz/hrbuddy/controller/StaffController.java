package org.frz.hrbuddy.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @GetMapping("/me")
    public ResponseEntity<Staff> getStaff(@RequestHeader("Authorization") String token){
        String username  = staffService.getUsernameFromToken(token);
        Staff staff = staffService.findStaff(username);
        return ResponseEntity.ok(staff);
    }
}
