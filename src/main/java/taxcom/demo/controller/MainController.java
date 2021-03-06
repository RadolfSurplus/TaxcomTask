package taxcom.demo.controller;

import org.springframework.web.bind.annotation.*;
import taxcom.demo.controller.exception.NotFoundException;
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

    @GetMapping("/search")
    public Optional<MainData> findByUUID(@RequestParam(value = "id") UUID id) throws NotFoundException {
        if (!service.existByUUID(id))
            throw new NotFoundException("There is no record with a specified UUID");
        else
            return service.findByUUID(id);
    }

    @PostMapping("/save")
    public @ResponseBody UUID saveData(@RequestBody String json) throws IOException {
        return service.saveJackson(json);
    }
}
