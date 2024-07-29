package org.frz.hrbuddy.dto;
import lombok.Data;
import org.frz.hrbuddy.model.Staff;

import java.util.Date;

@Data
public class StaffDto {
    private String name;
    private String position;
    private String phone;
    private Date dateOfBirth;
    private String personalEmail;
    private String workEmail;
    private int departmentId;
    private Staff supervisor;
    private int locationId;
    private String jobTitle;
    private int JobLevel;
    private double currentSalary;


}
