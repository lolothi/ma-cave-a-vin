package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.CellarPlaceNotEmptyException;
import macaveavin.app.api.repository.CellarPlaceRepository;
import macaveavin.app.api.repository.CellarRepository;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.CellarPlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<CellarPlaceDto> getCellarPlaces() {
        return ((List<CellarPlace>) cellarPlaceRepository.findAll()).stream()
                .map(wine -> cellarPlaceMapper.convertToDto(Optional.ofNullable(wine)))
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
        cellarPlace.setPositionX(updatedCellarPlaceDto.getPositionX());
        cellarPlace.setPositionY(updatedCellarPlaceDto.getPositionY());
        cellarPlace.setPositionZ(updatedCellarPlaceDto.getPositionZ());
        cellarPlace.setPositionOpt(updatedCellarPlaceDto.getPositionOpt());
        cellarPlace.setQuantityBottleMax(updatedCellarPlaceDto.getQuantityBottleMax());
        cellarPlace.setQuantityBottleLeft(updatedCellarPlaceDto.getQuantityBottleLeft());

        Optional<Wine> optionalWine = wineRepository.findById(updatedCellarPlaceDto.getWineId());
        Wine wine = optionalWine.orElse(null);
        Optional<Cellar> optionalCellar = cellarRepository.findById(updatedCellarPlaceDto.getCellarId());
        Cellar cellar = optionalCellar.orElse(null);

        if (wine != null && cellar != null) {
            cellarPlace.setWine(wine);
            cellarPlaceRepository.save(cellarPlace);
            cellarPlace.setCellar(cellar);
            cellarRepository.save(cellar);
            return Optional.ofNullable(cellarPlaceMapper.convertToDto(Optional.of(cellarPlace)));
        }

        System.out.println("-----Wine dans CellarPlace est NULL");
        return Optional.empty();
    }

    public CellarPlaceDto createNewCellarPlace(CellarPlaceDto cellarPlaceDto) {
        if (cellarPlaceRepository.getCellarPlaceByPosition(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ()).isEmpty()) {
            Optional<Wine> optionalWine = wineRepository.findById(cellarPlaceDto.getWineId());
            Optional<Cellar> optionalCellar = cellarRepository.findById(cellarPlaceDto.getCellarId());
            Wine wine = optionalWine.orElse(null);
            Cellar cellar = optionalCellar.orElse(null);

            if (wine != null && cellar != null) {
                cellarPlaceRepository.save(cellarPlaceMapper.convertToEntity(cellarPlaceDto, wine, cellar));
                return cellarPlaceDto;
            }
        } else {
            throw new CellarPlaceNotEmptyException("L'emplacement n'est pas vide.");
        }

        return null;
    }

    public String deleteCellarPlace(Long id) {
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceRepository.delete(cellarPlace);
        return "Emplacement de bouteille supprimé";
    }
}
