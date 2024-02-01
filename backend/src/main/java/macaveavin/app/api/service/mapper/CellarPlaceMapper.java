package macaveavin.app.api.service.mapper;

import macaveavin.app.api.dto.CellarPlaceDto;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CellarPlaceMapper {
    public CellarPlaceDto convertToDto(Optional<CellarPlace> cellarPlace) {
        return new CellarPlaceDto(cellarPlace.get().getCellar_place_id(), cellarPlace.get().getPositionX(), cellarPlace.get().getPositionY(), cellarPlace.get().getPositionZ(), cellarPlace.get().getPositionOpt(), cellarPlace.get().getQuantityBottleMax(), cellarPlace.get().getQuantityBottleLeft(), cellarPlace.get().getWine().getWineId(), cellarPlace.get().getCellar().getCellar_id());
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Wine wine, Cellar cellar) {
        return new CellarPlace(cellarPlaceDto.getPositionX(), cellarPlaceDto.getPositionY(), cellarPlaceDto.getPositionZ(), cellarPlaceDto.getPositionOpt(), cellarPlaceDto.getQuantityBottleMax(), cellarPlaceDto.getQuantityBottleLeft(), wine, cellar);
    }
}
