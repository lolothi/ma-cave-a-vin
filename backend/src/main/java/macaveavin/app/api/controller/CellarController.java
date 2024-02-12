package macaveavin.app.api.controller;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.service.CellarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://192.168.1.13:5173")
@RestController
public class CellarController {
    @Autowired
    private CellarService cellarService;

    @GetMapping("/cellar")
    public List<CellarDto> getCellars() {
        //for tests
        if (cellarService.getCellars().isEmpty()) {
            cellarService.createNewCellar(new CellarDto(1L, "cave_1", 10, 10, 10, 100));
            cellarService.createNewCellar(new CellarDto(2L, "cave_2", 12, 10, 10, 99));
            cellarService.createNewCellar(new CellarDto(3L, "cave_3", 13, 10, 10, 53));
        }
        return cellarService.getCellars();
    }

    @GetMapping("/cellar/{id}")
    public CellarDto getOneCellar(@PathVariable Long id) {
        return cellarService.getCellar(id);
    }

    @PatchMapping("/cellar/{id}")
    public CellarDto updateCellar (@RequestBody CellarDto updatedCellarDto, @PathVariable Long id) {
        return cellarService.updateCellar(updatedCellarDto, id);
    }

    @PostMapping("/cellar")
    public CellarDto createNewCellar(@RequestBody CellarDto newCellarDto) {
        return  cellarService.createNewCellar(newCellarDto);
    }

    @DeleteMapping("/cellar/{id}")
    public String deleteCellar(@PathVariable Long id) {
        return cellarService.deleteCellar(id);
    }

}
