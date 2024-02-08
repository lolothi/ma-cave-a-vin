package macaveavin.app.api.controller;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.service.CellarPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://192.168.1.13:5173")
@RestController
public class CellarPlaceController {
    @Autowired
    private CellarPlaceService cellarPlaceService;

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
        CellarPlaceDto cellarPlaceDto = cellarPlaceService.createNewCellarPlace(newCellarPlaceDto);
        return newCellarPlaceDto;
//        return cellarPlaceService.createNewCellarPlace(newCellarPlaceDto);
    }

    @DeleteMapping("/cellarplace/{id}")
    public String deleteCellarPlace(@PathVariable Long id) {
        return cellarPlaceService.deleteCellarPlace(id);
    }

}
