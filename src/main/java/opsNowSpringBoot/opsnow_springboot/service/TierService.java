package opsNowSpringBoot.opsnow_springboot.service;

import opsNowSpringBoot.opsnow_springboot.model.Employee;
import opsNowSpringBoot.opsnow_springboot.repository.TierRepository;
import org.springframework.stereotype.Service;
import opsNowSpringBoot.opsnow_springboot.model.Tier;
import java.util.List;

@Service
public class TierService {


    private final TierRepository repo;

    public TierService(TierRepository repo) {
        this.repo = repo;
    }

    public List<Tier> getAll() { return repo.findAll(); }
    public Tier getById(int id) { return repo.findById(id); }
    public int create(Tier t) { return repo.save(t); }
    public int update(Tier t) { return repo.update(t); }
    public int delete(int id) { return repo.delete(id); }
}
