package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarPlaceWineDto;
import macaveavin.app.api.entity.CellarPlaceWine;
import macaveavin.app.api.repository.CellarPlaceWineRepository;
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

    public List<CellarPlaceWineDto> getCellarPlaceWines() {
        return ((List<CellarPlaceWine>)cellarPlaceWineRepository.findAll()).stream().map(CellarPlaceWine -> cellarPlaceWineMapper.convertToDto(Optional.ofNullable(CellarPlaceWine))).collect(Collectors.toList());
    }

    public Optional<CellarPlaceWineDto> getCellarPlaceWine(Long id) {
        Optional<CellarPlaceWine> cellarPlaceWine = cellarPlaceWineRepository.findById(id);
        if (cellarPlaceWine.isPresent()) {
            return Optional.ofNullable(cellarPlaceWineMapper.convertToDto(cellarPlaceWine));
        }
        return Optional.empty();
    }
    public Optional<CellarPlaceWineDto> updateCellarPlaceWine(CellarPlaceWineDto updatedCellarPlaceWine, Long id) {
        CellarPlaceWine cellarPlaceWine = cellarPlaceWineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("erreur id:"+id));
        if(updatedCellarPlaceWine.getQuantityBottle() != null) {
            cellarPlaceWine.setQuantityBottle(updatedCellarPlaceWine.getQuantityBottle());
        }
        cellarPlaceWineRepository.save(cellarPlaceWine);
        return Optional.ofNullable(cellarPlaceWineMapper.convertToDto(Optional.of(cellarPlaceWine)));
    }

    public CellarPlaceWineDto createNewCellarPlaceWine(CellarPlaceWineDto cellarPlaceWineDto) {
        if (cellarPlaceWineDto.getCellarPlace() != null && cellarPlaceWineDto.getWine() != null) {
            try {
                CellarPlaceWine cellarPlaceWine = cellarPlaceWineMapper.convertToEntity(cellarPlaceWineDto);
                cellarPlaceWineRepository.save(cellarPlaceWine);
                return cellarPlaceWineMapper.convertToDto(Optional.of(cellarPlaceWine));
            } catch (Exception e) {
                throw new RuntimeException("Une erreur s'est produite lors de la sauvegarde du remplissage de l'emplacement", e);
            }
        }
        throw new RuntimeException("Une erreur s'est produite lors de la sauvegarde du remplissage de l'emplacement");
    }

    public String deleteCelarPlaceWine(Long id) {
        CellarPlaceWine cellarPlaceWine = cellarPlaceWineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarPlaceWineRepository.delete(cellarPlaceWine);
        return "Bouteille sortie de son emplacement";
    }

}
