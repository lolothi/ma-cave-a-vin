package macaveavin.app.api.service;

import macaveavin.app.api.dto.MyWineDto;
import macaveavin.app.api.entity.MyWine;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.MyWineRepository;
import macaveavin.app.api.repository.WineRepository;
import macaveavin.app.api.service.mapper.MyWineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyWineService {
    @Autowired
    private MyWineRepository myWineRepository;

    @Autowired
    private MyWineMapper myWineMapper;

    @Autowired
    private WineRepository wineRepository;

    public List<MyWineDto> getMyWines() {
        return ((List<MyWine>) myWineRepository.findAll()).stream()
                .map(wine -> myWineMapper.convertToDto(Optional.ofNullable(wine)))
                .collect(Collectors.toList());
    }

    public Optional<MyWineDto> getMyWine(Long id){
        Optional<MyWine> myWine = myWineRepository.findById(id);
        if (myWine.isPresent()) {
            return Optional.ofNullable(myWineMapper.convertToDto(myWine));
        }
        return Optional.empty();
    }

    public Optional<MyWineDto> updateMyWine(MyWineDto updatedMyWineDto, Long id){
        MyWine myWine = myWineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        myWine.setPosition(updatedMyWineDto.getPosition());
        myWine.setQuantity(updatedMyWineDto.getQuantity());

        Optional<Wine> optionalWine = wineRepository.findById(updatedMyWineDto.getMyWine_id());
        Wine wine = optionalWine.orElse(null);

        if (wine != null) {
            myWine.setWine(wine);
            myWineRepository.save(myWine);
            return Optional.ofNullable(myWineMapper.convertToDto(Optional.of(myWine)));
        }
        System.out.println("-----Wine dans MyWine est NULL");
        return Optional.empty();
    }

    public MyWineDto saveMyWine(MyWineDto myWineDto) {
        Optional<Wine> optionalWine = wineRepository.findById(myWineDto.getMyWine_id());
        Wine wine = optionalWine.orElse(null);

        if (wine != null) {
            myWineRepository.save(myWineMapper.convertToEntity(myWineDto, wine));
            return myWineDto;
        }
        return null;
    }

    public String deleteMyWine(Long id) {
        MyWine myWine = myWineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Erreur id:" + id));
        myWineRepository.delete(myWine);
        return "Vin supprimé";
    }
}
