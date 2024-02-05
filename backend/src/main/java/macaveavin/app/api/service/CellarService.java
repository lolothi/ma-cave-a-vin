package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.repository.CellarRepository;
import macaveavin.app.api.service.mapper.CellarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CellarService {
    @Autowired
    private CellarRepository cellarRepository;

    @Autowired
    private CellarMapper cellarMapper;

    @Autowired
    private SharedServices sharedServices;

    public List<CellarDto> getCellars() {
        return ((List<Cellar>)cellarRepository.findAll()).stream()
                .map(cellar -> cellarMapper.convertToDto(Optional.ofNullable(cellar)))
                .collect(Collectors.toList());
    }

    public Optional<CellarDto> getCellar(Long id) {
        Optional<Cellar> cellar = cellarRepository.findById(id);
        if (cellar.isPresent()) {
            return Optional.ofNullable(cellarMapper.convertToDto(cellar));
        }
        return Optional.empty();
    }

    public Optional<CellarDto> updateCellar(CellarDto updatedCellarDto, Long id) {
        Cellar cellar = cellarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        sharedServices.updateFields(cellar, updatedCellarDto);
        cellarRepository.save(cellar);
        return Optional.ofNullable(cellarMapper.convertToDto(Optional.of(cellar)));
    }

    public CellarDto createNewCellar (CellarDto cellarDto) {
        cellarRepository.save(cellarMapper.convertToEntity(cellarDto));
        return cellarDto;
    }

    public String deleteCellar (Long id) {
        Cellar cellar = cellarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        cellarRepository.delete(cellar);
        return "cave supprimée";
    }
}
