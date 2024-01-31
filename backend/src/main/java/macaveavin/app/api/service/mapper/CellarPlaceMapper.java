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
        return new CellarPlaceDto(cellarPlace.get().getCellar_place_id(), cellarPlace.get().getPosition_x(), cellarPlace.get().getPosition_y(), cellarPlace.get().getPosition_z(), cellarPlace.get().getPosition_opt(), cellarPlace.get().getQuantity_bottle_max(), cellarPlace.get().getQuantity_bottle_left(), cellarPlace.get().getWine(), cellarPlace.get().getCellar());
    }

    public CellarPlace convertToEntity(CellarPlaceDto cellarPlaceDto, Wine wine, Cellar cellar) {
        return new CellarPlace(cellarPlaceDto.getPosition_x(), cellarPlaceDto.getPosition_y(), cellarPlaceDto.getPosition_z(), cellarPlaceDto.getPosition_opt(), cellarPlaceDto.getQuantity_bottle_max(), cellarPlaceDto.getQuantity_bottle_left(), wine, cellar);
    }
}
