package org.frz.hrbuddy.service;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.LocationDto;
import org.frz.hrbuddy.model.Location;
import org.frz.hrbuddy.model.Staff;
import org.frz.hrbuddy.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<LocationDto> getAllLocations() {
        List<LocationDto> locationDtos = new ArrayList<>();
        for(Location location : locationRepository.findAll()){
            locationDtos.add(LocationDto.from(location));
        }
        return locationDtos;
    }

    public LocationDto getLocationById(int id) {
        return LocationDto.from(locationRepository.findById(id));
    }

    public Location newLocation(LocationDto locationDto) {
        Location location = Location.builder()
                .name(locationDto.getName())
                .country(locationDto.getCountry())
                .shortCode(locationDto.getShortCode())
                .functional(true)
                .build();

        locationRepository.save(location);
        return location;
    }

    public void changeStatus(int id, boolean status) {
        Location location = locationRepository.findById(id);
        location.setFunctional(status);
        locationRepository.save(location);
    }

    public String editLocation(LocationDto locationDto, int id) {
        Location location = locationRepository.findById(id);
        location.setName(locationDto.getName());
        location.setCountry(locationDto.getCountry());
        location.setShortCode(locationDto.getShortCode());
        locationRepository.save(location);
        return location.getName();
    }

    public String deleteLocation(int id) {
        Location location = locationRepository.findById(id);
        locationRepository.delete(location);
        return location.getName();
    }

    public String assignPresident(int id, Staff president) {
        Location location = locationRepository.findById(id);
        location.setPresident(president);
        locationRepository.save(location);

        return location.getName();
    }
}
