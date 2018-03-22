package taxcom.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taxcom.demo.domain.MainData;
import taxcom.demo.service.MainService;

import java.util.List;

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
}
