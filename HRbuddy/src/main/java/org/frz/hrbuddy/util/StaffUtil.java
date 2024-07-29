package org.frz.hrbuddy.util;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.StaffDto;
import org.frz.hrbuddy.model.Department;
import org.frz.hrbuddy.model.Location;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.repository.LocationRepository;
import org.frz.hrbuddy.repository.StaffRepository;
import org.frz.hrbuddy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffUtil {
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    public String generateUsername(String name, Location location, Department department){
        int curr = (int)userRepository.count() + 1;
        StringBuilder num = new StringBuilder(String.valueOf(curr));
        int numLoops = 5 - num.length();
        for (int i = 0; i < numLoops; i++ ){
            num.insert(0, "0");
        }
        String first = location.getShortCode();
        String third = name.substring(0, 1);
        String second = department.getShortCode();

        return first + second + third + num.toString();

    }

    //To be worked on Later and moved to a utility class
    public String getUsernameFromToken(String token){
        return "username";
    }
}
