package opsNowSpringBoot.opsnow_springboot.controller;

import opsNowSpringBoot.opsnow_springboot.model.Tier;
import opsNowSpringBoot.opsnow_springboot.service.TierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tier")
public class TierController {

    private final TierService service;

    public TierController(TierService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tier> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Tier getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Tier t) {
        service.create(t);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Tier t) {
        t.setTiercode(id);
        service.update(t);

    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable int id) {
        service.delete(id);

    }
}
