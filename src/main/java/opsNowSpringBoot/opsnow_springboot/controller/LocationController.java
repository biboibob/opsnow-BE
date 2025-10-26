package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.service.LocationService;
import opsNowSpringBoot.opsnow_springboot.model.Location;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Location> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Location l) {
        service.create(l);
        return "Location created successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Location l) {
        l.setLocationcode(id);
        service.update(l);
        return "Location updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Location deleted successfully";
    }
}
