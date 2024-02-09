package macaveavin.app.api.controller;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.dto.CellarPlaceWineDto;
import macaveavin.app.api.dto.CellarPlaceWineSetDto;
import macaveavin.app.api.service.CellarPlaceService;
import macaveavin.app.api.service.CellarPlaceWineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://192.168.1.13:5173")
@RestController
public class CellarPlaceController {
    @Autowired
    private CellarPlaceService cellarPlaceService;

    @Autowired
    private CellarPlaceWineService cellarPlaceWineService;

    @GetMapping("/cellarplace")
    public List<CellarPlaceDto> getCellarPlaces() {
        return cellarPlaceService.getCellarPlaces();
    }

    @GetMapping("/cellarplace/{id}")
    public Optional<CellarPlaceDto> getOneCellarPlace(@PathVariable Long id) {
        return cellarPlaceService.getCellarPlace(id);
    }

    @PatchMapping("/cellarplace/{id}")
    public Optional<CellarPlaceDto> updateCellarPlace(@RequestBody CellarPlaceDto updatedCellarPlaceDto, @PathVariable Long id) {
        return cellarPlaceService.updateCellarPlace(updatedCellarPlaceDto, id);
    }

    @PostMapping("/cellarplace")
    public CellarPlaceDto createNewCellarPlace(@RequestBody CellarPlaceDto newCellarPlaceDto) {
        System.out.println("newCellarPlaceDto: "+newCellarPlaceDto);
        return cellarPlaceService.createNewCellarPlace(newCellarPlaceDto);
    }

    @DeleteMapping("/cellarplace/{id}")
    public String deleteCellarPlace(@PathVariable Long id) {
        return cellarPlaceService.deleteCellarPlace(id);
    }

    //to fill cellar place with bottle
    @GetMapping("/cellarplace/filling/{id}")
    public Optional<CellarPlaceWineDto> getOneCellarPlaceWine(@PathVariable Long id) {
        return cellarPlaceWineService.getCellarPlaceWine(id);
    }

    @GetMapping("/cellarplace/filling")
    public List<CellarPlaceWineDto> getCellarPlaceWines() {
        return cellarPlaceWineService.getCellarPlaceWines();
    }

    @PatchMapping("/cellarplace/filling/{id}")
    public Optional<CellarPlaceWineDto> updateCellarPlaceWine(@RequestBody CellarPlaceWineDto updatedCellarPlaceWineDto, @PathVariable Long id) {
        return cellarPlaceWineService.updateCellarPlaceWine(updatedCellarPlaceWineDto, id);
    }

    @PostMapping("/cellarplace/filling")
    public Optional<CellarPlaceWineDto> createNewCellarPlaceWine(@RequestBody CellarPlaceWineSetDto cellarPlaceWineSetDto) {
        return Optional.ofNullable(cellarPlaceWineService.createNewCellarPlaceWine(cellarPlaceWineSetDto));
    }

    @DeleteMapping("/cellarplace/filling/{id}")
    public String deleteCellarPlaceWine(@PathVariable Long id) {
        return cellarPlaceWineService.deleteCelarPlaceWine(id);
    }

}
