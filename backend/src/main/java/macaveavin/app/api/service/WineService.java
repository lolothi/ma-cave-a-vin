package macaveavin.app.api.service;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.WineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private WineMapper wineMapper;

    @Autowired
    private SharedServices sharedServices;

    public List<WineDto> getWines() {
        return ((List<Wine>) wineRepository.findAll()).stream()
                .map(wine -> wineMapper.convertToDto(Optional.ofNullable(wine)))
                .collect(Collectors.toList());
    }

    public Optional<WineDto> getWine(Long id){
        Optional<Wine> wine = wineRepository.findById(id);
        if (wine.isPresent()) {
            return Optional.ofNullable(wineMapper.convertToDto(wine));
        }
        return Optional.empty();
    }

    public Optional<WineDto> updateWine(WineDto updatedWineDto, Long id){
        Wine wine = wineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        sharedServices.updateFields(wine, updatedWineDto);
        wineRepository.save(wine);
        return Optional.ofNullable(wineMapper.convertToDto(Optional.of(wine)));
    }

    public WineDto createNewWine(WineDto wineDto) {
        wineRepository.save(wineMapper.convertToEntity(wineDto));
        return wineDto;
    }

    public String deleteWine(Long id) {
        Wine wine = wineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        wineRepository.delete(wine);
        return "Vin supprimé";
    }
}
