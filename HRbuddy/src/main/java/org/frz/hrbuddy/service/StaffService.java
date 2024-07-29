package org.frz.hrbuddy.service;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.StaffDto;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.model.User;
import org.frz.hrbuddy.repository.StaffRepository;
import org.frz.hrbuddy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    public String addStaff(StaffDto staffDto) {
        User user = userRepository.findById(staffDto.getUserId()).orElse(
                userRepository.save(
                        User.builder()
                                .username("user"+new Date().toString())
                                .password("123456")
                                .role("staff")
                                .build()));
        Staff staff = Staff.builder()
                .user(user)
                .name(staffDto.getName())
                .phone(staffDto.getPhone())
                .department(staffDto.getDepartment())
                .position(staffDto.getPosition())
                .personalEmail(staffDto.getPersonalEmail())
                .dateOfBirth(staffDto.getDateOfBirth())
                .workEmail(staffDto.getWorkEmail())
                .department(staffDto.getDepartment())
                .jobTitle(staffDto.getJobTitle())
                .jobLevel(staffDto.getJobLevel())
                .currentSalary(staffDto.getCurrentSalary())
                .createdDate(new Date())
                .build();

        staffRepository.save(staff);
        return staff.getName();
    }

    public String editStaff(Long staffId, StaffDto staffDto){
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
        staff.setDepartment(staffDto.getDepartment());
        staff.setPosition(staffDto.getPosition());
        staff.setDepartment(staffDto.getDepartment());
        staff.setJobTitle(staffDto.getJobTitle());
        staff.setJobLevel(staffDto.getJobLevel());
        staff.setCurrentSalary(staffDto.getCurrentSalary());

        staffRepository.save(staff);
        return staff.getName();
        }
        return null;
    }

    public String deleteStaff(Long staffId){
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if(staff != null){
            staffRepository.delete(staff);
            return staff.getName();
        }
        return "Done";
    }

    public String assignSupervisor(Long staffId, Long supervisorId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        Staff supervisor = staffRepository.findById(supervisorId).orElse(null);

        if (staff != null && supervisor != null) {
            staff.setSupervisor(supervisor);
            return "Successful";
        }
        else{
            return "Unsuccessful";
        }
    }

    public Staff findStaff(Long staffId){
        return staffRepository.findById(staffId).orElse(null);
    }

    public Staff findStaff(String username){
        User user = userRepository.findByUsername(username);
        return staffRepository.findByUser(user);
    }

    public List<Staff> findAllStaff(){
        return staffRepository.findAll();
    }

    //To be worked on Later and moved to a utility class
    public String getUsernameFromToken(String token){
        return "username";
    }

    public String changeSalary(Long staffId, double salary) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            staff.setCurrentSalary(salary);
            staffRepository.save(staff);
            return "Successful";
        }
        return "Unsuccessful";
    }

    public String changeDepartment(Long staffId, String department) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            staff.setDepartment(department);
            staffRepository.save(staff);
            return "Successful";
        }
        return "Unsuccessful";
    }

    public String changePosition(Long staffId, String position) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            staff.setPosition(position);
            staffRepository.save(staff);
            return "Successful";
        }
        return "Unsuccessful";
    }

    public String changeLocation(Long staffId, String location){
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            staff.setLocation(location);
            staffRepository.save(staff);
            return "Successful";
        }
        return "Unsuccessful";
    }

    public String changeJobTitle(Long staffId, String title){
        Staff staff = staffRepository.findById(staffId).orElse(null);
        if (staff != null) {
            staff.setJobTitle(title);
            staffRepository.save(staff);
            return "Successful";
        }
        return "Unsuccessful";
    }
}
