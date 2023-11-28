package macaveavin.app.api.controller;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://192.168.1.13:5173")
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello guys !";
    }

    @GetMapping("/wine")
    public List<WineDto> geWines() {
        return  wineService.getWines();
    }

    @GetMapping("/wine/{id}")
    public Optional<WineDto> getOneWine(@PathVariable Long id) {
        return wineService.getWine(id);
    }

    @PatchMapping("wine/{id}")
    public Optional<WineDto> updateWine(@RequestBody WineDto updatedWineDto, @PathVariable Long id) {
        return wineService.updateWine(updatedWineDto, id);
    }

    @PostMapping("/wine")
    public WineDto saveWine(@RequestBody WineDto newWineDto) {
        return wineService.saveWine(newWineDto);
    }

    @DeleteMapping("/wine/{id}")
    public String deleteWine(@PathVariable Long id) {
        return wineService.deleteWine(id);
    }
}
