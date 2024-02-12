package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceWineDto;
import macaveavin.app.api.dto.CellarPlaceWineSetDto;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.CellarPlaceWine;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.*;
import macaveavin.app.api.service.mapper.CellarPlaceWineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CellarPlaceWineService {
    @Autowired
    private CellarPlaceWineRepository cellarPlaceWineRepository;

    @Autowired
    private CellarPlaceWineMapper cellarPlaceWineMapper;

    @Autowired
    private CellarPlaceRepository cellarPlaceRepository;

    @Autowired
    private WineRepository wineRepository;


    public List<CellarPlaceWineDto> getCellarPlaceWines() {
        return ((List<CellarPlaceWine>)cellarPlaceWineRepository.findAll()).stream()
                .map(CellarPlaceWine -> cellarPlaceWineMapper.convertToDto(CellarPlaceWine))
                .collect(Collectors.toList());
    }

    public CellarPlaceWineDto getCellarPlaceWine(Long id) {
        Optional<CellarPlaceWine> optionalCellarPlaceWine = cellarPlaceWineRepository.findById(id);
        if (optionalCellarPlaceWine.isPresent()) {
            CellarPlaceWine cellarPlaceWine = optionalCellarPlaceWine.get();
            return cellarPlaceWineMapper.convertToDto(cellarPlaceWine);
        }
        return null;
    }
    public CellarPlaceWineDto updateCellarPlaceWine(CellarPlaceWineDto updatedCellarPlaceWine, Long id) {
        Optional<CellarPlaceWine> optionalCellarPlaceWine = cellarPlaceWineRepository.findById(id);
        if (optionalCellarPlaceWine.isPresent()) {
            if(updatedCellarPlaceWine.getQuantityBottle() != null) {
                CellarPlaceWine cellarPlaceWine = optionalCellarPlaceWine.get();
                cellarPlaceWine.setQuantityBottle(updatedCellarPlaceWine.getQuantityBottle());
                cellarPlaceWineRepository.save(cellarPlaceWine);
                return cellarPlaceWineMapper.convertToDto(cellarPlaceWine);
            }

        } else {
            throw new IllegalArgumentException("Erreur id:" + id);
        }
        return null;
    }

    public CellarPlaceWineDto createNewCellarPlaceWine(CellarPlaceWineSetDto cellarPlaceWineSetDto) {
        if (cellarPlaceWineSetDto.getCellarPlaceId() != null && cellarPlaceWineSetDto.getWineId() != null) {
            try {
                Long cellarPlaceId = cellarPlaceWineSetDto.getCellarPlaceId();
                CellarPlace cellarPlace = cellarPlaceRepository.findById(cellarPlaceId).orElseThrow(() -> new IllegalArgumentException("erreur cellarPlaceId"));
                if (cellarPlaceWineRepository.getBottlesQuantityByCellarPlaceByPosition(cellarPlaceId)+cellarPlaceWineSetDto.getQuantityBottle() <= cellarPlace.getQuantityBottleMax()){
                    Wine wine = wineRepository.findById(cellarPlaceWineSetDto.getWineId()).orElseThrow(() -> new IllegalArgumentException("erreur wineId"));
                    CellarPlaceWine cellarPlaceWine = cellarPlaceWineMapper.convertToEntity(cellarPlaceWineSetDto, cellarPlace, wine);
                    cellarPlaceWineRepository.save(cellarPlaceWine);
                    return cellarPlaceWineMapper.convertToDto(cellarPlaceWine);
                }
                throw new CellarPlaceNotEmptyException("Plus de place dans l'emplacement");
            } catch (Exception e) {
                throw new RuntimeException("Une erreur s'est produite lors de la sauvegarde du remplissage de l'emplacement", e);
            }

        }
        throw new RuntimeException("Une erreur s'est produite lors de la sauvegarde du remplissage de l'emplacement");
    }

    public String deleteCellarPlaceWine(Long id) {
        CellarPlaceWine cellarPlaceWine = cellarPlaceWineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceWineRepository.delete(cellarPlaceWine);
        return "Bouteille sortie de son emplacement";
    }

}
