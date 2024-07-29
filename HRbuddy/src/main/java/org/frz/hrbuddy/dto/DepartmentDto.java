package org.frz.hrbuddy.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.frz.hrbuddy.model.Location;
import org.frz.hrbuddy.model.Staff;

import java.util.List;

@Data
public class DepartmentDto {
    private String name;
    private String description;
    private String shortCode;
    private  int locationId;
}
