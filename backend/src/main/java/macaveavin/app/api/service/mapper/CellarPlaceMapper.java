package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.CellarPlaceWine;
import macaveavin.app.api.entity.Wine;
import macaveavin.app.api.repository.CellarPlaceWineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class CellarPlaceMapper {
    @Autowired
    private CellarPlaceWineRepository cellarPlaceWineRepository;


    public CellarPlaceDto convertToDto(Optional<CellarPlace> cellarPlace) {
        Integer quantityOfBottles = countQuantityOfBottlesInCellarPlace(cellarPlace.get().getCellar_place_id());

        return new CellarPlaceDto(cellarPlace.get().getCellar_place_id(), cellarPlace.get().getPositionX(), cellarPlace.get().getPositionY(),
                cellarPlace.get().getPositionZ(), cellarPlace.get().getPositionOpt(), cellarPlace.get().getQuantityBottleMax(), cellarPlace.get().get,
                cellarPlaceWineRepository, cellarPlace.get().getCellar_place_id(), cellarPlace.get().getCellar().getCellar_id());
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Cellar cellar) {
        return new CellarPlace(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ(), cellarPlaceDto.getPositionOpt(),
                cellarPlaceDto.getQuantityBottleMax(), cellar);
    }

    private Integer countQuantityOfBottlesInCellarPlace(Long id) {
        return cellarPlaceWineRepository.getBottlesQuantityByCellarPlaceByPosition(id);
    }
}
