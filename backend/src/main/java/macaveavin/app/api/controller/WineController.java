package macaveavin.app.api.controller;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.WineTypeEnum;
import macaveavin.app.api.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello guys !";
    }

    @GetMapping("/wine")
    public List<WineDto> geWines() {
        //for tests
        if (wineService.getWines().isEmpty()) {
            wineService.saveWine(new WineDto(1L, "Château Margaux", 2010, WineTypeEnum.RED, "France",
                    "Château Margaux", "Cabernet Sauvignon", "Grand Cru Classé", "1234567890123",
                    "image1.jpg", "Grilled meats", 95, "A classic Bordeaux wine", "Premium",
                    100, 50));
            wineService.saveWine(new WineDto(2L, "Barolo Riserva", 2012, WineTypeEnum.RED, "Italy", "Ceretto",
                    "Nebbiolo", "Riserva", "2345678901234", "image2.jpg",
                    "Pasta with truffle sauce", 93, "A rich and robust Barolo", "Reserve", 75, 25));
            wineService.saveWine(new WineDto(3L, "Riesling Spätlese", 2015, WineTypeEnum.WHITE, "Germany",
                    "Dr. Loosen", "Riesling", "Spätlese", "3456789012345", "image3.jpg",
                    "Spicy Thai cuisine", 88, "A sweet and aromatic Riesling", "Sweet", 50, 20));

        }
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
