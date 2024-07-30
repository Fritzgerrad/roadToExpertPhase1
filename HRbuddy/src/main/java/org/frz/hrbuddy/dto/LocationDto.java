package org.frz.hrbuddy.dto;

import lombok.Builder;
import lombok.Data;
import org.frz.hrbuddy.model.Department;
import org.frz.hrbuddy.model.Location;
import org.frz.hrbuddy.model.Staff;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
public class LocationDto {
    private int id;
    private String name;
    private String shortCode;
    private String country;
    private long presidentId;
    private boolean functional;;
    private List<Integer> departmentIds;



    public static LocationDto from(final Location location) {
        List<Integer> dr = new ArrayList<>();
        for (Department department : location.getDepartments()) {
            dr.add(department.getId());
        }
        return LocationDto.builder()
                .name(location.getName())
                .id(location.getId())
                .shortCode(location.getShortCode())
                .country(location.getCountry())
                .presidentId(location.getPresident() != null ? location.getPresident().getId() : 0)
                .functional(location.isFunctional())
                .departmentIds(dr)
                .build();
    }
}
