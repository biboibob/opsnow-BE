package opsNowSpringBoot.opsnow_springboot.service;

import opsNowSpringBoot.opsnow_springboot.model.Location;
import opsNowSpringBoot.opsnow_springboot.controller.LocationController;
import opsNowSpringBoot.opsnow_springboot.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository repo;

    public LocationService(LocationRepository repo) {
        this.repo = repo;
    }

    public List<Location> getAll() { return repo.findAll(); }
    public Location getById(String id) { return repo.findById(id); }
    public int create(Location l) { return repo.save(l); }
    public int update(Location l) { return repo.update(l); }
    public int delete(String id) { return repo.delete(id); }
}
