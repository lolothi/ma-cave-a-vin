package macaveavin.app.api.controller;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello guys !";
    }

    @GetMapping("/vin/{id}")
    public Optional<WineDto> getOneWine(@PathVariable Long id) {
        return wineService.getWine(id);
    }

    @PostMapping("/vin")
    public WineDto saveWine(@RequestBody WineDto newWineDto) {
        return wineService.saveWine(newWineDto);
    }
}
