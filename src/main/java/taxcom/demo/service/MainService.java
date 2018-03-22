package taxcom.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import taxcom.demo.domain.MainData;
import taxcom.demo.repository.MainRepository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class MainService {

    private MainRepository repository;

    public MainService(MainRepository repository) {
        this.repository = repository;
    }

    public UUID saveJackson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MainData data = objectMapper.readValue(json, MainData.class);
        repository.save(data);
        return data.getId();
    }

    public MainData findByUUID(UUID id) {
        return repository.findById(id);
    }
}
