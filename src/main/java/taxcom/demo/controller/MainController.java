package taxcom.demo.controller;

import org.springframework.web.bind.annotation.*;
import taxcom.demo.domain.MainData;
import taxcom.demo.service.MainService;

import java.util.*;

@RestController
public class MainController {

    private MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public List<MainData> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MainData> findByID(@PathVariable Integer id) {
        return service.findByID(id);
    }
}
