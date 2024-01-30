package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.CellarPlaceRepository;
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
    private CellarPlaceRepository CellarPlaceRepository;

    @Autowired
    private CellarPlaceMapper cellarPlaceMapper;

    @Autowired
    private WineRepository wineRepository;

    public List<CellarPlaceDto> getCellarPlaces() {
        return ((List<CellarPlace>) CellarPlaceRepository.findAll()).stream()
                .map(wine -> cellarPlaceMapper.convertToDto(Optional.ofNullable(wine)))
                .collect(Collectors.toList());
    }

    public Optional<CellarPlaceDto> getCellarPlace(Long id){
        Optional<CellarPlace> myWine = CellarPlaceRepository.findById(id);
        if (myWine.isPresent()) {
            return Optional.ofNullable(cellarPlaceMapper.convertToDto(myWine));
        }
        return Optional.empty();
    }

    public Optional<CellarPlaceDto> updateCellarPlace(CellarPlaceDto updatedCellarPlaceDto, Long id){
        CellarPlace cellarPlace = CellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlace.setPosition(updatedCellarPlaceDto.getPosition());
        cellarPlace.setQuantity(updatedCellarPlaceDto.getQuantity());

        Optional<Wine> optionalWine = wineRepository.findById(updatedCellarPlaceDto.getCellar_place_id());
        Wine wine = optionalWine.orElse(null);

        if (wine != null) {
            cellarPlace.setWine(wine);
            CellarPlaceRepository.save(cellarPlace);
            return Optional.ofNullable(cellarPlaceMapper.convertToDto(Optional.of(cellarPlace)));
        }
        System.out.println("-----Wine dans CellarPlace est NULL");
        return Optional.empty();
    }

    public CellarPlaceDto saveCellarPlace(CellarPlaceDto cellarPlaceDto) {
        Optional<Wine> optionalWine = wineRepository.findById(cellarPlaceDto.getWine().getWine_id());
        Wine wine = optionalWine.orElse(null);
        if (wine != null) {
            CellarPlaceRepository.save(cellarPlaceMapper.convertToEntity(cellarPlaceDto, wine));
            return cellarPlaceDto;
        }
        return null;
    }

    public String deleteCellarPlace(Long id) {
        CellarPlace cellarPlace = CellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        CellarPlaceRepository.delete(cellarPlace);
        return "Vin supprimé";
    }
}
