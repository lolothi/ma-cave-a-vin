package macaveavin.app.api.service;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.entity.WineTypeEnum;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.WineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .map(wine -> wineMapper.convertToDto(wine))
                .collect(Collectors.toList());
    }

    public List<WineDto> getWinesByType(Optional<WineTypeEnum> wineType) {
        return wineRepository.getWinesByType(wineType).stream()
                .map(wine -> wineMapper.convertToDto(wine))
                .collect(Collectors.toList());
    }

    public WineDto getWine(Long id){
        Optional<Wine> optionalWine = wineRepository.findById(id);
        if (optionalWine.isPresent()) {
            Wine wine = optionalWine.get();
            return wineMapper.convertToDto(wine);
        }
        return null;
    }

    public WineDto updateWine(WineDto updatedWineDto, Long id){
        Optional<Wine> optionalWine = wineRepository.findById(id);
        if (optionalWine.isPresent()) {
            Wine wine = optionalWine.get();
            sharedServices.updateFields(optionalWine, updatedWineDto);
            wineRepository.save(wine);
            return wineMapper.convertToDto(wine);
        } else {
            throw new IllegalArgumentException("Erreur id:" + id);
        }
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
