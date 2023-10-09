package macaveavin.app.api.controller;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello guys !";
    }

    @GetMapping("/vin")
    public List<WineDto> geWines() {
        return  wineService.getWines();
    }

    @GetMapping("/vin/{id}")
    public Optional<WineDto> getOneWine(@PathVariable Long id) {
        return wineService.getWine(id);
    }

    @PatchMapping("vin/{id}")
    public Optional<WineDto> updateWine(@RequestBody WineDto updatedWineDto, @PathVariable Long id) {
        return wineService.updateWine(updatedWineDto, id);
    }

    @PostMapping("/vin")
    public WineDto saveWine(@RequestBody WineDto newWineDto) {
        return wineService.saveWine(newWineDto);
    }

    @DeleteMapping("/vin/{id}")
    public String deleteWine(@PathVariable Long id) {
        return wineService.deleteWine(id);
    }
}
