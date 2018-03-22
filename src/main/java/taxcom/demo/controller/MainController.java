package taxcom.demo.controller;

import org.springframework.web.bind.annotation.*;
import taxcom.demo.domain.MainData;
import taxcom.demo.service.MainService;

import java.io.IOException;
import java.util.*;

@RestController
public class MainController {

    private MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<MainData> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MainData findByUUID(@PathVariable UUID id) {
        return service.findByUUID(id);
    }

    @PostMapping("/save")
    public @ResponseBody UUID saveData(String json) throws IOException {
        return service.saveJackson(json);
    }
}
