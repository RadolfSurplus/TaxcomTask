package taxcom.demo.service;

import org.springframework.stereotype.Service;
import taxcom.demo.domain.MainData;
import taxcom.demo.repository.MainRepository;

import java.util.List;

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
}
