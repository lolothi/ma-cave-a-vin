package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
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
    private CellarRepository cellarRepository;

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
        if (updatedCellarPlaceDto.getCellarId() != null) {
            Optional<Cellar> optionalCellar = cellarRepository.findById(updatedCellarPlaceDto.getCellarId());
            optionalCellar.ifPresent(cellarPlace::setCellar);
        }
        cellarPlaceRepository.save(cellarPlace);
        return Optional.ofNullable(cellarPlaceMapper.convertToDto(Optional.of(cellarPlace)));
    }

    /**
     * Create new cellar place for a bottle or a group of bottles.
     * Check in first if cellar Place is used.
     * @param cellarPlaceDto
     * @return
     */
    public CellarPlaceDto createNewCellarPlace(CellarPlaceDto cellarPlaceDto) {
        Cellar cellar = cellarRepository.findById(cellarPlaceDto.getCellarId()).orElse(null);
        if (cellar != null) {
            // Check if enough place in cellar Place :
            if (cellarPlaceRepository.getCellarPlaceByPosition(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ()).isEmpty()) {
                try {
                    CellarPlace cellarPlace = cellarPlaceMapper.convertToEntity(cellarPlaceDto, cellar);
                    return cellarPlaceMapper.convertToDto(Optional.of(cellarPlaceRepository.save(cellarPlace)));
                } catch (Exception e) {
                    throw new RuntimeException("Une erreur s'est produite lors de la sauvegarde de l'emplacement.", e);
                }
            } else {
                throw new CellarPlaceNotEmptyException("Emplacement déja utilisé");
            }
        }
        return null;
    }

    public String deleteCellarPlace(Long id) {
        CellarPlace cellarPlace = cellarPlaceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceRepository.delete(cellarPlace);
        return "Emplacement de bouteille supprimé";
    }
}
