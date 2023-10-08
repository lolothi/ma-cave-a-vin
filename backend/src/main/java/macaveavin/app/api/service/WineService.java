package macaveavin.app.api.service;

import macaveavin.app.api.dto.WineDto;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.WineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private WineMapper wineMapper;

    public WineService() {
    }

    /*
    public List<WineDto> getWines() {
        return ((List<Wine>) wineRepository.findAll()).stream()
                .map(wine -> wineMapper.convertToDto(Optional.ofNullable(wine)))
                .collect(Collectors.toList());
    } */

    public Optional<WineDto> getWine(Long id){
        Optional<Wine> wine = wineRepository.findById(id);
        System.out.println("-----wine: "+ wine);
        if (wine.isPresent()) {
            return Optional.ofNullable(wineMapper.convertToDto(wine));
        }
        return Optional.empty();
    }

    public WineDto saveWine(WineDto wineDto) {
        wineRepository.save(wineMapper.convertToEntity(wineDto));
        return wineDto;
    }
}
