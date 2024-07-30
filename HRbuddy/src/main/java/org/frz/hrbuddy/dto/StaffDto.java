package org.frz.hrbuddy.dto;
import lombok.Data;
import org.frz.hrbuddy.model.Staff;

import java.util.Date;

@Data
public class StaffDto {
    private Long userId;
    private String name;
    private String position;
    private String phone;
    private Date dateOfBirth;
    private String personalEmail;
    private String workEmail;
    private String department;
    private Staff supervisor;
    private String location;
    private String jobTitle;
    private int JobLevel;
    private double currentSalary;


}
