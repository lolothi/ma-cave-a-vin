package macaveavin.app.api.controller;

import macaveavin.app.api.dto.MyWineDto;
import macaveavin.app.api.service.MyWineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyWineController {
    @Autowired
    private MyWineService myWineService;

    @GetMapping("/mywine")
    public List<MyWineDto> getMyWines() {
        return myWineService.getMyWines();
    }

    @GetMapping("/mywine/{id}")
    public Optional<MyWineDto> getOneMyWine(@PathVariable Long id) {
        return myWineService.getMyWine(id);
    }

    @PatchMapping("/mywine/{id}")
    public Optional<MyWineDto> updateMyWine(@RequestBody MyWineDto updatedMyWineDto, @PathVariable Long id) {
        return myWineService.updateMyWine(updatedMyWineDto, id);
    }

    @PostMapping("/mywine")
    public MyWineDto saveMyWine(@RequestBody MyWineDto newMyWineDto) {
        return myWineService.saveMyWine(newMyWineDto);
    }

    @DeleteMapping("/mywine/{id}")
    public String deleteMyWine(@PathVariable Long id) {
        return myWineService.deleteMyWine(id);
    }

}
