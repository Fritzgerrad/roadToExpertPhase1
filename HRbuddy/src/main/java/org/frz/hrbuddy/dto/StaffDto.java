package org.frz.hrbuddy.dto;
import lombok.Builder;
import lombok.Data;
import org.frz.hrbuddy.model.Staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class StaffDto {
    private Long id;
    private int userId;
    private String name;
    private String position;
    private String phone;
    private LocalDate dateOfBirth;
    private String personalEmail;
    private String workEmail;
    private int departmentId;
    private int locationId;
    private String jobTitle;
    private int jobLevel;
    private double currentSalary;
    private List<Long> directReports;
    private Long supervisorId;

    public static StaffDto from(Staff staff) {
        List<Long> dr = new ArrayList<>();
        for (Staff s : staff.getDirectReports()){
            dr.add(s.getId());
        }
        Staff supervisor = staff.getSupervisor();
        Long superId = supervisor != null ? supervisor.getId() : 0 ;
        return StaffDto.builder()
                .id(staff.getId())
                .name(staff.getName())
                .userId(staff.getUser().getId())
                .position(staff.getPosition())
                .phone(staff.getPhone())
                .dateOfBirth(staff.getDateOfBirth())
                .personalEmail(staff.getPersonalEmail())
                .workEmail(staff.getWorkEmail())
                .departmentId(staff.getDepartment().getId())
                .locationId(staff.getLocation().getId())
                .jobTitle(staff.getJobTitle())
                .jobLevel(staff.getJobLevel())
                .currentSalary(staff.getCurrentSalary())
                .directReports(dr)
                .supervisorId(superId)
                .build();

        }
    }


