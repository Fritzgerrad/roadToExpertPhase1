package org.frz.hrbuddy.dto;

import lombok.Builder;
import lombok.Data;
import org.frz.hrbuddy.model.Department;
import org.frz.hrbuddy.model.Staff;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DepartmentDto {
    private int id;
    private String name;
    private String description;
    private String shortCode;
    private  int locationId;
    private long managerId;
    private double budget;
    private boolean active;
    private List<Long> memberIds;

    public static DepartmentDto from( Department department ) {
        List<Long> dr = new ArrayList<>();
        for (Staff s : department.getMembers()){
            dr.add(s.getId());
        }
        return DepartmentDto.builder()
                .id( department.getId() )
                .name( department.getName() )
                .shortCode( department.getShortCode() )
                .description( department.getDescription() )
                .locationId(department.getId())
                .managerId(department.getManager() != null ? department.getManager().getId() : 0)
                .budget( department.getBudget() )
                .active( department.isActive() )
                .memberIds(dr)
                .build();
    }
}
