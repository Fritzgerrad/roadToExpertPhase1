package org.frz.hrbuddy.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.StaffDto;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.service.StaffService;
import org.frz.hrbuddy.util.StaffUtil;
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
    private final StaffUtil staffUtil;

    @GetMapping("/me")
    public ResponseEntity<StaffDto> getStaff(@RequestHeader("Authorization") String token){
        String username  = staffUtil.getUsernameFromToken(token);
        StaffDto staff = staffService.findStaff(username);
        return ResponseEntity.ok(staff);
    }
}
