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
                .map(cellar -> cellarMapper.convertToDto(cellar))
                .collect(Collectors.toList());
    }

    public CellarDto getCellar(Long id) {
        Optional<Cellar> optionalCellar = cellarRepository.findById(id);
        if (optionalCellar.isPresent()) {
            Cellar cellar = optionalCellar.get();
            return cellarMapper.convertToDto(cellar);
        }
        return null;
    }

    public CellarDto updateCellar(CellarDto updatedCellarDto, Long id) {
        Optional<Cellar> optionalCellar = cellarRepository.findById(id);
        if (optionalCellar.isPresent()) {
            Cellar cellar = optionalCellar.get();
            sharedServices.updateFields(cellar, updatedCellarDto);
            cellarRepository.save(cellar);
            return cellarMapper.convertToDto(cellar);
        } else {
            throw new IllegalArgumentException("Erreur id:" + id);
        }
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
