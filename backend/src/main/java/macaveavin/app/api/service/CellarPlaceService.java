package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
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
        Optional<CellarPlace> myWine = cellarPlaceRepository.findById(id);
        if (myWine.isPresent()) {
            return Optional.ofNullable(cellarPlaceMapper.convertToDto(myWine));
        }
        return Optional.empty();
    }

    public Optional<CellarPlaceDto> updateCellarPlace(CellarPlaceDto updatedCellarPlaceDto, Long id){
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlace.setPosition_x(updatedCellarPlaceDto.getPosition_x());
        cellarPlace.setPosition_y(updatedCellarPlaceDto.getPosition_y());
        cellarPlace.setPosition_z(updatedCellarPlaceDto.getPosition_z());
        cellarPlace.setPosition_opt(updatedCellarPlaceDto.getPosition_opt());
        cellarPlace.setQuantity_bottle_max(updatedCellarPlaceDto.getQuantity_bottle_max());
        cellarPlace.setQuantity_bottle_left(updatedCellarPlaceDto.getQuantity_bottle_left());

        Optional<Wine> optionalWine = wineRepository.findById(updatedCellarPlaceDto.getWine().getWine_id());
        Wine wine = optionalWine.orElse(null);
        Optional<Cellar> optionalCellar = cellarRepository.findById(updatedCellarPlaceDto.getCellar().getCellar_id());
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

    public CellarPlaceDto saveCellarPlace(CellarPlaceDto cellarPlaceDto) {
        Optional<Wine> optionalWine = wineRepository.findById(cellarPlaceDto.getWine().getWine_id());
        Optional<Cellar> optionalCellar = cellarRepository.findById(cellarPlaceDto.getCellar().getCellar_id());
        Wine wine = optionalWine.orElse(null);
        Cellar cellar = optionalCellar.orElse(null);

        if (wine != null && cellar != null) {
            cellarPlaceRepository.save(cellarPlaceMapper.convertToEntity(cellarPlaceDto, wine, cellar));
            return cellarPlaceDto;
        }
        return null;
    }

    public String deleteCellarPlace(Long id) {
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceRepository.delete(cellarPlace);
        return "Vin supprimé";
    }
}
