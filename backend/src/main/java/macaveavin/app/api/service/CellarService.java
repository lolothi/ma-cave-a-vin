package macaveavin.app.api.service;

import macaveavin.app.api.dto.CellarDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
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

    public List<CellarDto> getCellars() {
        return null;
/*        return cellarRepository.findAll().stream().map(cellar -> cellarMapper
                .convertToDto(Optional.ofNullable(cellar))).collect(Collectors.toList());*/
    }

}
