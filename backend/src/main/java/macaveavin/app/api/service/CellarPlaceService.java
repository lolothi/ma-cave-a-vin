package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.*;
import macaveavin.app.api.service.mapper.CellarPlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CellarPlaceService {
    @Autowired
    private CellarPlaceRepository cellarPlaceRepository;

    @Autowired
    private CellarPlaceMapper cellarPlaceMapper;

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private CellarRepository cellarRepository;

    @Autowired
    private SharedServices sharedServices;




    public List<CellarPlaceDto> getCellarPlaces() {
        return ((List<CellarPlace>) cellarPlaceRepository.findAll()).stream().filter(Objects::nonNull)
                .map(cellarPlace -> cellarPlaceMapper.convertToDto(Optional.of(cellarPlace)))
                .collect(Collectors.toList());
    }

    public Optional<CellarPlaceDto> getCellarPlace(Long id){
        Optional<CellarPlace> cellarPlace = cellarPlaceRepository.findById(id);
        if (cellarPlace.isPresent()) {
            return Optional.ofNullable(cellarPlaceMapper.convertToDto(cellarPlace));
        }
        return Optional.empty();
    }

    public Optional<CellarPlaceDto> updateCellarPlace(CellarPlaceDto updatedCellarPlaceDto, Long id){
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));

        if (updatedCellarPlaceDto.getPositionX() != null) {
            cellarPlace.setPositionX(updatedCellarPlaceDto.getPositionX());
        }
        if (updatedCellarPlaceDto.getPositionY() != null) {
            cellarPlace.setPositionY(updatedCellarPlaceDto.getPositionY());
        }
        if (updatedCellarPlaceDto.getPositionZ() != null) {
            cellarPlace.setPositionZ(updatedCellarPlaceDto.getPositionZ());
        }
        if (updatedCellarPlaceDto.getPositionOpt() != null) {
            cellarPlace.setPositionOpt(updatedCellarPlaceDto.getPositionOpt());
        }
        if (updatedCellarPlaceDto.getQuantityBottleMax() != null) {
            cellarPlace.setQuantityBottleMax(updatedCellarPlaceDto.getQuantityBottleMax());
        }
/*        if (updatedCellarPlaceDto.getQuantityBottleLeft() != null) {
            cellarPlace.setQuantityBottleLeft(updatedCellarPlaceDto.getQuantityBottleLeft());
        }*/
/*        if (updatedCellarPlaceDto.getWineId() != null) {
            Optional<Wine> optionalWine = wineRepository.findById(updatedCellarPlaceDto.getWineId());
            optionalWine.ifPresent(cellarPlace::setWine);
        }*/
        if (updatedCellarPlaceDto.getCellarId() != null) {
            Optional<Cellar> optionalCellar = cellarRepository.findById(updatedCellarPlaceDto.getCellarId());
            optionalCellar.ifPresent(cellarPlace::setCellar);
        }
        cellarPlaceRepository.save(cellarPlace);
        return Optional.ofNullable(cellarPlaceMapper.convertToDto(Optional.of(cellarPlace)));
    }

    /**
     * Create new cellar place for a bottle or a group of bottles. Is checking if the cellar place is empty
     * @param cellarPlaceDto
     * @return
     */
    public CellarPlaceDto createNewCellarPlace(CellarPlaceDto cellarPlaceDto) {
        if (cellarPlaceRepository.getCellarPlaceByPosition(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ()).isEmpty()) {
            Optional<Wine> optionalWine = wineRepository.findById(cellarPlaceDto.getWineId());
            Optional<Cellar> optionalCellar = cellarRepository.findById(cellarPlaceDto.getCellarId());
            Wine wine = optionalWine.orElse(null);
            Cellar cellar = optionalCellar.orElse(null);

            if (wine != null && cellar != null) {
                cellarPlaceRepository.save(cellarPlaceMapper.convertToEntity(cellarPlaceDto, wine, cellar));
                return cellarPlaceDto;
            } else {
                throw new CellarPlaceNotEmptyException("Erreur vin et/ou cave");
            }
        } else {
            throw new CellarPlaceNotEmptyException("L'emplacement n'est pas vide.");
        }
    }

    public String deleteCellarPlace(Long id) {
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceRepository.delete(cellarPlace);
        return "Emplacement de bouteille supprimé";
    }
}
