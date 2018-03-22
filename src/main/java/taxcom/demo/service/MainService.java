package taxcom.demo.service;

import org.springframework.stereotype.Service;
import taxcom.demo.domain.MainData;
import taxcom.demo.repository.MainRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    private MainRepository repository;

    public MainService(MainRepository repository) {
        this.repository = repository;
    }

    public void dataSave(MainData data) {
        repository.save(data);
    }

    public List<MainData> findAll() {
        return (List<MainData>) repository.findAll();
    }

    public Optional<MainData> findByID(Integer id) {
        return repository.findById(id);
    }
}
